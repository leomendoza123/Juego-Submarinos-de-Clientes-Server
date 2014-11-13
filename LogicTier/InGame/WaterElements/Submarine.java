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
public class Submarine extends Underwater{
    public int control_depht, control_speed, control_direction; 
    
    public Submarine(int loot_value, int size, int speed, int depth, Color color, Double direction, Point localisation) {
        super(loot_value, size, speed, depth, color, direction, localisation);
    }

    @Override
    public String toString() {
        return "Submarine{" + "control_depht=" + control_depht + ", control_speed=" + control_speed + ", control_direction=" + control_direction + '}';
    }
    
    
    
    
}
