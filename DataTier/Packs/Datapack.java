/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTier.Packs;

import LogicTier.InGame.Players.Player;
import LogicTier.InGame.WaterElements.Submarine;
import LogicTier.InGame.WaterElements.WaterElement;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Leonardo
 */
public class Datapack implements Serializable{
    public Lock DatapackLock = new ReentrantLock();
    public Submarine self; 
    public ArrayList<WaterElement> neighborhood;
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
    
    

    @Override
    public String toString() {
        return "datapack{" + "self=" + self + ", player=" + player + '}';
    }
    
    
}
