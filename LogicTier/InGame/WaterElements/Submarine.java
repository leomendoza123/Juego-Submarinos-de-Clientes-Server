/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicTier.InGame.WaterElements;

import java.awt.Color;
import java.awt.Point;
import static java.lang.Math.abs;

/**
 *
 * @author Leonardo
 */
public class Submarine extends Underwater {

    public double control_speed, control_direction, control_depht;

    public  int radar_efficiency ; 
    public Submarine(int loot_value, int size, double speed, double depth, Color color, Double direction, Point localisation) {
        super(loot_value, size, speed, depth, color, direction, localisation);
        radar_efficiency = 0;
        propeller_efficiency = 0;
        inmersion_efficiency = 0;
        rudder_efficiency = 0;
    }

    @Override
    public void stateupdating() {
        controlTest();

    }

    private void controlTest() {

        if (this.depth != this.control_depht) {
            
            double diference = control_depht - depth;
            if (abs(diference)>inmersion_efficiency)
            if (diference > 0) {
                depth += inmersion_efficiency * 5;
            } else {
                depth -= inmersion_efficiency * 5;
            }

        }

        if (this.direction != this.control_direction) {
            double diference = control_direction - direction;
            if (abs(diference) > rudder_efficiency) {
                if (abs(diference) > 180) {
                    if (diference > 0) {
                        direction -= rudder_efficiency * 5;
                    } else {
                        direction += rudder_efficiency * 5;
                    }
                } else {
                    if (diference > 0) {
                        direction += rudder_efficiency * 5;
                    } else {
                        direction -= rudder_efficiency * 5;
                    }
                }
                if (direction > 359.9) {
                    direction = 0.1;
                }
                if (direction < 0.1) {
                    direction = 359.9;
                }
            }
        }
        if (this.speed != this.control_speed) {
            
            double diference = control_speed - speed;
            if (abs(diference)> propeller_efficiency)
            if (diference > 0) {
                speed += propeller_efficiency * 5;
            } else {
                speed -= propeller_efficiency + 5;
            }
            

        }
    }

}
