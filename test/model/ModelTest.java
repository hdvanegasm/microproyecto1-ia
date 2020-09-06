/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

/**
 *
 * @author user
 */
public class ModelTest {
    public static void main(String[] args) {
        String filename = "src/model/apple_model.fcl";
        FIS fuzzyModel = FIS.load(filename);
        if(fuzzyModel == null) {
            System.err.println("Can't load the file");
            System.exit(1);
        }
        
        fuzzyModel.setVariable("size", 80);
        fuzzyModel.setVariable("red_color", 0.90);
        fuzzyModel.setVariable("spots", 0.05);
        
        fuzzyModel.evaluate();
        
        JFuzzyChart.get().chart(fuzzyModel.getFunctionBlock("quality"));
        
        double result = fuzzyModel.getVariable("quality").getLatestDefuzzifiedValue();
        
        System.out.println("The predicted value is: " + result);
        fuzzyModel.getFunctionBlock("quality").getFuzzyRuleBlock("No1").getRules().forEach((r) -> {
            System.out.println(r);
        });
    }
}
