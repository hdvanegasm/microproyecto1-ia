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
import model.FuzzyModel;
import view.AppleUI;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import java.util.List;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class CalculateListener implements ActionListener {
    
    private final AppleUI view;
    
    public CalculateListener(AppleUI view) {
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String diameter = this.view.getDiameter();
        String spotsPercentage = this.view.getSpotsPercentage();
        String redIntensity = this.view.getRedIntensity();
        if (!diameter.isEmpty() && !spotsPercentage.isEmpty() && !redIntensity.isEmpty()) {
            double diameterInput = Double.parseDouble(diameter);
            double spotsPercentageInput = Double.parseDouble(spotsPercentage);
            double redIntensityInput = Double.parseDouble(redIntensity);
            
            if (diameterInput < 50 || diameterInput > 90) {
                this.view.showError("Invalid Diameter.");
            } else if(spotsPercentageInput < 0 || spotsPercentageInput > 1) {
                this.view.showError("Invalid Percentage.");
            } else if(redIntensityInput < 0 || redIntensityInput > 1) {
                this.view.showError("Invalid Red Intensity.");
            } else {
                double quality = FuzzyModel.getQuality(
                    diameterInput, redIntensityInput, spotsPercentageInput 
                );
                
                List<Rule> rules = FuzzyModel.getRules(
                        diameterInput, redIntensityInput, spotsPercentageInput
                );
                view.showResults(quality, rules);
                JFuzzyChart.get().chart(FuzzyModel
                        .getModel()
                        .getFunctionBlock("quality"));
            }
        }
    }
}
