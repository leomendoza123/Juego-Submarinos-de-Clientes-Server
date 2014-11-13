/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicTier.InGame.WaterElements;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Leonardo
 */
public class Submarine extends Underwater {

    public int control_depht;
    public double control_speed, control_direction;
    
    public double turbine_efficiency;

    public Submarine(int loot_value, int size, int speed, int depth, Color color, Double direction, Point localisation) {
        super(loot_value, size, speed, depth, color, direction, localisation);
        turbine_efficiency = 0.1; 
    }

    @Override
    public void stateupdating() {
        controlTest();

    }

    private void controlTest() {

        
        this.depth = this.control_depht;
        this.direction = (double) this.control_direction;
        
        if  (this.speed!=this.control_speed){
            double diference = control_speed-speed; 
            if (diference>0){
                speed+=turbine_efficiency; 
            }
            else{
                speed-=turbine_efficiency; 
            }
            
        }
    }


    
    
    
    
}
