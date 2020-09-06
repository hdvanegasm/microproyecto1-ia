/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
/**
 *
 * @author pvillegasg
 */
import java.awt.event.ActionListener;
public class CalculateListener implements ActionListener {
    
    private double diameter;
    private double spots_percentage;
    private double red_intensity;
    
    public CalculateListener(String diameter, String spots_percentage, String red_intensity) {
        // this.diameter = diameter;
        // this.spots_percentage = spots_percentage;
        // this.red_intensity = red_intensity;
    }
    
    public void actionPerformed(ActionEvent e) {
        System.out.println("It works");
    }
    
}
