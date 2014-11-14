/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicTier.InGame.Players;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Leonardo
 */
public class Team implements Serializable{
    public Lock TeamLock = new ReentrantLock();
    public String name; 
    public String leader; 
    public ArrayList<String> members; 
    

    @Override
    public String toString() {
        return "team{" + "name=" + name + '}';
    }

    public Team(String name, String leader) {
        this.name = name;
        this.leader = leader;
        members = new ArrayList();

    }

    public Team() {
        members = new ArrayList();
        name = null; 
        leader = null; 
        
        
    }
    
    
    
}