/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicTier.Server;

import DataTier.Packs.Datapack;
import DataTier.Server.TheardToClient;
import LogicTier.InGame.Players.Player;
import LogicTier.InGame.Players.Team;
import LogicTier.InGame.WaterElements.Ship;
import LogicTier.InGame.WaterElements.WaterElement;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class Ocean extends Thread {

    public Lock OceanListLock = new ReentrantLock();
    ArrayList<WaterElement> neighborhood = new ArrayList<>();
    ArrayList<Team> neighborhoodTeams = new ArrayList<>();
    ArrayList<Datapack> clients = new ArrayList<>();
    boolean OceanRuning;

    public boolean addclient(Datapack e) {
        OceanListLock.lock();
        boolean result = clients.add(e);
        OceanListLock.unlock();
        return result;
    }

    private boolean addneighbor(WaterElement e) {
        OceanListLock.lock();
        boolean result = neighborhood.add(e);
        OceanListLock.unlock();
        return result;
    }

    public Ocean() {
        OceanRuning = true;
        this.setName("Ocean");
        initializeShips();
    }

    @Override
    public void run() {
        while (OceanRuning) {
            clientNeighborhoodUpdate();
            addNewWaterElementsFromClients();
            startNewWaterElements();
            teamManagement();
            clientNeighborhoodTeamUpdate();
        }
    }

    private void startNewWaterElements() {
        OceanListLock.lock();
        for (WaterElement waterElement : neighborhood) {
            if (waterElement != null) {
                if (!waterElement.runing) {
                    waterElement.WaterElementLock.lock();
                    waterElement.setName("Water Element:" + waterElement.getId());
                    waterElement.runing = true;
                    waterElement.start();
                    waterElement.WaterElementLock.unlock();
                }
            }
        }
        OceanListLock.unlock();
    }

    private void addNewWaterElementsFromClients() {
        OceanListLock.lock();
        for (Datapack client : clients) {
            if (client.self != null && !neighborhood.contains(client.self)) {
                addneighbor(client.self);
            }
        }
        OceanListLock.unlock();
    }

    private void initializeShips() {

        Random r = new Random();
        Point Localization;
        for (int i = 0; i < 300; i++) {
            Localization = new Point(r.nextInt() % 500000, r.nextInt() % 500000);
            Ship newShip = new Ship(10, 0, 0, 0, Color.BLACK, 0.0, Localization);
            neighborhood.add(newShip);
        }
    }

    private void clientNeighborhoodUpdate() {

        OceanListLock.lock();
        for (Datapack datapack : clients) {
            datapack.DatapackLock.lock();
            try {
                datapack.neighborhood = new ArrayList<>();
                for (WaterElement neighbor : neighborhood) {
                    if (neighbor != datapack.self) {
                        datapack.neighborhood.add(neighbor);
                    }
                }
            } finally {
                datapack.DatapackLock.unlock();
            }
        }
        OceanListLock.unlock();

    }

    private void clientNeighborhoodTeamUpdate() {

        OceanListLock.lock();
        for (Datapack datapack : clients) {
            datapack.DatapackLock.lock();
            try {
                datapack.neighborhoodTeams = new ArrayList<>();
                for (Team neighborTeam : neighborhoodTeams) {
                    datapack.neighborhoodTeams.add(neighborTeam);
                }
            } finally {
                datapack.DatapackLock.unlock();
            }
        }
        OceanListLock.unlock();

    }

    private void teamManagement() {

        OceanListLock.lock();

        // Crea equipo 
        for (Datapack clientDatapackRequester : clients) {
            clientDatapackRequester.DatapackLock.lock();

            TeamManagmentNewTeams(clientDatapackRequester);
            TeamManagmentJoinTeam(clientDatapackRequester);
            TeamManagmentAceptMember (clientDatapackRequester); 

            clientDatapackRequester.DatapackLock.unlock();
        }

        OceanListLock.unlock();

    }

    private void TeamManagmentAceptMember(Datapack clientDatapackRequester) {
        if (!"".equals(clientDatapackRequester.acepmember.toString())) {
            // Se quiere aceptar a un nuevo miembro
            for (Team neighborhoodTeam : neighborhoodTeams) {
                if (neighborhoodTeam.leader.equals(clientDatapackRequester.player.name)){
                    neighborhoodTeam.members.add(clientDatapackRequester.acepmember.toString());
                    clientDatapackRequester.acepmember = new StringBuffer(""); 
                    
     
                }
            }

        }
    }

    private void TeamManagmentJoinTeam(Datapack clientDatapackRequester) {
        if (!"".equals(clientDatapackRequester.SendRequestToJoinTeam.toString())) {
            // Se quiere hacer un join team request
            for (Team neighborhoodTeam : neighborhoodTeams) {
                if (neighborhoodTeam.name == null ? clientDatapackRequester.SendRequestToJoinTeam.toString() == null : neighborhoodTeam.name.equals(clientDatapackRequester.SendRequestToJoinTeam.toString())) {
                    /// Busca al leader para mandarle la notificacion
                    for (Datapack clientsDatapackReciver : clients) {
                        if (clientsDatapackReciver.player.name.equals(neighborhoodTeam.leader)) {
                            clientsDatapackReciver.GetRequestToJoinTeam = new StringBuffer(clientDatapackRequester.player.name);
                            clientDatapackRequester.SendRequestToJoinTeam = new StringBuffer("");

                        }
                    }
                }
            }

        }
    }

    private void TeamManagmentNewTeams(Datapack clientDatapack) {
        // Equipos nuevos
        if (!"".equals(clientDatapack.newTeam.toString())) {
            neighborhoodTeams.add(new Team(clientDatapack.newTeam.toString(), clientDatapack.player.name));
            clientDatapack.newTeam = new StringBuffer("");

        }
    }
    
    private void ChatManagment(Datapack clientDatapack){
        for (Datapack currentDatapackSender: clients){
            if (""!=currentDatapackSender.SendChatMessage.toString()){
                // Si esta enviando un mensaje
                for (Datapack curreDatapackReciver: clients){
                    double Distance =  (currentDatapackSender.self.localisation.distance(curreDatapackReciver.self.localisation));
                    if (Distance<currentDatapackSender.self.radar_efficiency){
                        curreDatapackReciver.getChatMessage.append(currentDatapackSender.SendChatMessage.toString());
                        currentDatapackSender.SendChatMessage = new StringBuffer("");                       
                    }
                }
            }
        }
    }
    
    
}
