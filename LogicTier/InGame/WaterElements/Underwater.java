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
public class Underwater extends WaterElement{
    
    
    public double propeller_efficiency;
    public double rudder_efficiency;
    public double inmersion_efficiency;

    public Underwater(int loot_value, int size, double speed, double depth, Color color, Double direction, Point localisation) {
        super(loot_value, size, speed, depth, color, direction, localisation);
    }
    
    
}
