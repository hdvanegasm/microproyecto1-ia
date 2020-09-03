/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Rule;

import java.util.List;

public class FuzzyModel {
    private static FIS model;
    
    public static FIS getModel() {
        if(model == null) {
            // TODO Implement .fcl
            String filePath = "src/model/apple_model.fcl";
            model = FIS.load(filePath);
            return model;
        } else {
            return model;
        }
    }
    
    private static FIS evaluateModel(
            double size, double redLevel, double spots) {
        // TODO fix variable names
        FIS fuzzyModel = getModel();
        fuzzyModel.setVariable("size", size);
        fuzzyModel.setVariable("red_level", redLevel);
        fuzzyModel.setVariable("spots", spots);
        
        return fuzzyModel;
    }
    
    public static double getQuality(
            double size, double redLevel, double spots) {
        FIS fuzzyModel = evaluateModel(size, redLevel, spots);
        return fuzzyModel.getVariable("quality").getLatestDefuzzifiedValue();
    }
    
    public static List<Rule> getRules(
            double size, double redLevel, double spots) {
        FIS fuzzyModel = evaluateModel(size, redLevel, spots);
        
        return fuzzyModel
                .getFunctionBlock("quality")
                .getFuzzyRuleBlock("No1")
                .getRules();
    }
}
