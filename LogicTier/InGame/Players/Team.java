/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicTier.InGame.Players;

import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
class Team {
    String name; 
    Player leader; 
    ArrayList<Player> members; 
    ArrayList<Player> request;

    @Override
    public String toString() {
        return "team{" + "name=" + name + '}';
    }
    
    
}