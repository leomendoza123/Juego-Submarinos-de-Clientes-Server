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
import PresentationTier.Cliente.Team;
import java.awt.Color;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class Datapack implements Serializable{
    public Lock DatapackLock = new ReentrantLock();
    public Submarine self; 
    public ArrayList<WaterElement> neighborhood;
    public ArrayList<Team> neighborhoodTeams;

    public Player player; 

    public Datapack(Submarine self, Player player) {
        neighborhood = new ArrayList<>(); 
        this.player = player; 
        this.self = self; 
    }

    public Datapack() {
        neighborhood = new ArrayList<>(); 
         this.player = new Player();
         this.self = null;    
    
    }
    
    
    public static void DataFromServerpackToClientpack(Datapack Clientdatapack,Datapack Serverdatapack) {
        Clientdatapack.DatapackLock.lock();
        String data = Serverdatapack.self.toString() + "\n";
        System.out.println(Serverdatapack);
        Clientdatapack.self.color = Serverdatapack.self.color;
        Clientdatapack.self.depth = Serverdatapack.self.depth;
        Clientdatapack.self.direction = Serverdatapack.self.direction;
        Clientdatapack.self.loot_value = Serverdatapack.self.loot_value;
        Clientdatapack.self.speed = Serverdatapack.self.speed;
        Clientdatapack.self.size = Serverdatapack.self.size;
        Clientdatapack.neighborhood  = Serverdatapack.neighborhood;
        Clientdatapack.self.localisation = Serverdatapack.self.localisation; 
        Clientdatapack.self.health = Clientdatapack.self.health; 
        if (Clientdatapack.player.points<Serverdatapack.player.points){
            Clientdatapack.player.points = Serverdatapack.player.points; 
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
        Serverpack.self.inmersion_efficiency =  Clientpack.self.inmersion_efficiency;
        Serverpack.self.rudder_efficiency =  Clientpack.self.rudder_efficiency;
        Serverpack.self.propeller_efficiency =  Clientpack.self.propeller_efficiency;
        
        if(Serverpack.player.points>Clientpack.player.points){
            Serverpack.player.points = Clientpack.player.points; 
        }

        Serverpack.DatapackLock.unlock();
        
  
    }
    
    

    @Override
    public String toString() {
        return "datapack{" + "self=" + self + ", player=" + player + '}';
    }
    
    
}
