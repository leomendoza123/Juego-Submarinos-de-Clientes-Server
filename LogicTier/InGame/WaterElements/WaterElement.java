/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicTier.InGame.WaterElements;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public abstract class WaterElement extends Thread implements Serializable {
    public int loot_value, size; 
    public double depth; 
    public double speed; 
    public double health; 
    public Color color; 
    public Double direction;
    public Point localisation;  
    public boolean runing= false; 
    public Lock WaterElementLock = new ReentrantLock();


    public WaterElement(int loot_value, int size, double speed, double depth, Color color, Double direction, Point localisation) {
        this.loot_value = loot_value;
        this.size = size;
        this.speed = speed;
        this.depth = depth;
        this.color = color;
        this.direction = direction;
        this.localisation= localisation;  
        
    }
    
    public void run (){
        while(runing){
            WaterElementLock.lock();
            moving();
            stateupdating();
            WaterElementLock.unlock();
            try { 
                sleep (100);
            } catch (InterruptedException ex) {
                Logger.getLogger(WaterElement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    
    public void stateupdating(){
        
    }

    private void moving() {
        if (speed>0){
          
                localisation.x += speed * sin(-1*toRadians(direction));
                localisation.y += speed * cos(-1*toRadians(direction));
                
        }
    }
    
    @Override
    public String toString() {
        return "water_element{" + "speed=" + speed + ", depth=" + depth + ", direction=" + direction + '}';
    }
    
    
}
