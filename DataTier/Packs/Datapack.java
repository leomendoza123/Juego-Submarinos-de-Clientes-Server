/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTier.Packs;

import DataTier.Server.TheardToClient;
import LogicTier.InGame.Players.Player;
import LogicTier.InGame.WaterElements.Submarine;
import LogicTier.InGame.WaterElements.WaterElement;
import java.awt.Color;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import LogicTier.InGame.Players.Team;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class Datapack implements Serializable {

    public Lock DatapackLock = new ReentrantLock();
    public Submarine self;
    public ArrayList<WaterElement> neighborhood;
    public ArrayList<Team> neighborhoodTeams;
    public Team newTeam;

    public Player player;

    public Datapack(Submarine self, Player player) {
        neighborhood = new ArrayList<>();
        neighborhoodTeams = new ArrayList<>();
        this.player = player;
        this.self = self;
        newTeam = new Team();
    }

    public Datapack() {
        neighborhood = new ArrayList<>();
        neighborhoodTeams = new ArrayList<>();
        this.player = new Player();
        this.self = null;
        newTeam = new Team();

    }

    public static void DataFromServerpackToClientpack(Datapack Clientdatapack, Datapack Serverdatapack) {
        Clientdatapack.DatapackLock.lock();
        String data = Serverdatapack.self.toString() + "\n";
        System.out.println(Serverdatapack);
        Clientdatapack.self.color = Serverdatapack.self.color;
        Clientdatapack.self.depth = Serverdatapack.self.depth;
        Clientdatapack.self.direction = Serverdatapack.self.direction;
        Clientdatapack.self.loot_value = Serverdatapack.self.loot_value;
        Clientdatapack.self.speed = Serverdatapack.self.speed;
        Clientdatapack.self.size = Serverdatapack.self.size;
        Clientdatapack.neighborhood = Serverdatapack.neighborhood;

        Clientdatapack.self.localisation = Serverdatapack.self.localisation;
        Clientdatapack.self.health = Clientdatapack.self.health;
        if (Clientdatapack.player.points < Serverdatapack.player.points) {
            Clientdatapack.player.points = Serverdatapack.player.points;
        }

        /// Manejo de vecinos
        // SI DETECTA ALGUN CAMBIO EN EL TAMAÑO DE LA LISTA 
        if (Clientdatapack.neighborhoodTeams.size() != Serverdatapack.neighborhoodTeams.size()) {
            Clientdatapack.neighborhoodTeams.clear();
            for (Team currentTeam : Serverdatapack.neighborhoodTeams) {
                Clientdatapack.neighborhoodTeams.add(currentTeam);
            }
            // Revisa que el Team que creo ya este creado 
            if (Clientdatapack.newTeam.name != null) {
                for (Team currentTeam : Serverdatapack.neighborhoodTeams) {
                    if (currentTeam.name == null ? Clientdatapack.newTeam.name == null : currentTeam.name.equals(Clientdatapack.newTeam.name)) {
                        Clientdatapack.newTeam.name = null;
                    }
                }

            }
        }

        for (Team currentServerTeam : Serverdatapack.neighborhoodTeams) {
            for (Team currentClienTeam : Clientdatapack.neighborhoodTeams) {
                if (currentClienTeam.name.equals(currentServerTeam.name)) {
                    // Busca el equipo equivalente
                    if (currentServerTeam.leader.name == null ? Clientdatapack.player.name == null : currentServerTeam.leader.name.equals(Clientdatapack.player.name)) {
                        // Si el cliente es dueño del team
                        if (currentClienTeam.aceptedRequest.size() > 0) {
                            /// >>> Revisa que el miembro que acepto ya este aceptado 
                            for (Player playerMember : currentServerTeam.members) {
                                if (playerMember.name.equals(currentClienTeam.aceptedRequest.get(0))) {
                                    currentClienTeam.aceptedRequest.clear();

                                }
                            }
                        }
                    }
                }
            }
        }

        Clientdatapack.DatapackLock.unlock();
    }

    public static void DataFromClientpackToServerPack(Datapack Clientpack, Datapack Serverpack) {
        Serverpack.DatapackLock.lock();
        Serverpack.player = Clientpack.player;
        Serverpack.self.WaterElementLock.lock();
        Serverpack.self.control_depht = Clientpack.self.control_depht;
        Serverpack.self.control_direction = Clientpack.self.control_direction;
        Serverpack.self.control_speed = Clientpack.self.control_speed;
        Serverpack.self.WaterElementLock.unlock();
        Serverpack.self.inmersion_efficiency = Clientpack.self.inmersion_efficiency;
        Serverpack.self.rudder_efficiency = Clientpack.self.rudder_efficiency;
        Serverpack.self.propeller_efficiency = Clientpack.self.propeller_efficiency;

        if (Serverpack.player.points > Clientpack.player.points) {
            Serverpack.player.points = Clientpack.player.points;
        }

        boolean team_existens;
        for (Team ClientcurrentTeam : Clientpack.neighborhoodTeams) {

            for (Team ServercurrentTeam : Serverpack.neighborhoodTeams) {

                // Encuentra los equipos equivalentes
                if (ClientcurrentTeam.name != null && (ClientcurrentTeam.name == null ? ServercurrentTeam.name == null : ClientcurrentTeam.name.equals(ServercurrentTeam.name))) {
                    team_existens = true;
                    // Si el cliente actual es el lider del equipo busca por request aceptados
                    if (ClientcurrentTeam.leader.name == null ? ServercurrentTeam.leader.name == null : ClientcurrentTeam.leader.name.equals(ServercurrentTeam.leader.name)) {
                        if (ClientcurrentTeam.aceptedRequest.size() > 0) {
                            ServercurrentTeam.members.add(ClientcurrentTeam.aceptedRequest.get(0));
                        }

                    }
                    // Busca si el cliente esta enviando request para entrar a un equipo
                    if (ClientcurrentTeam.request.size() > 0) {
                        ServercurrentTeam.request.add(ClientcurrentTeam.request.get(0));
                    }
                }

            }

        }
        if (Clientpack.newTeam.name != null) {
            Serverpack.neighborhoodTeams.add(Clientpack.newTeam);
        }

        Serverpack.DatapackLock.unlock();

    }

    @Override
    public String toString() {
        return "datapack{" + "self=" + self + ", player=" + player + '}';
    }

}
