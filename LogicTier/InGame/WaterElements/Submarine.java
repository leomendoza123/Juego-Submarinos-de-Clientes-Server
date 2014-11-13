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

    public double control_speed, control_direction, control_depht;

    public Submarine(int loot_value, int size, double speed, double depth, Color color, Double direction, Point localisation) {
        super(loot_value, size, speed, depth, color, direction, localisation);
        propeller_efficiency = 1;
    }

    @Override
    public void stateupdating() {
        controlTest();

    }

    private void controlTest() {



        if (this.depth != this.control_depht) {
            double diference = control_depht - depth;
            if (diference > 0) {
                depth += inmersion_efficiency;
            } else {
                depth -= inmersion_efficiency;
            }

        }

        if (this.direction != this.control_direction) {
            double diference = control_direction - direction;
            if (diference > 0) {
                direction += rudder_efficiency;
            } else {
                direction -= rudder_efficiency;
            }

        }
        if (this.speed != this.control_speed) {
            double diference = control_speed - speed;
            if (diference > 0) {
                speed += propeller_efficiency;
            } else {
                speed -= propeller_efficiency;
            }

        }
    }

}
