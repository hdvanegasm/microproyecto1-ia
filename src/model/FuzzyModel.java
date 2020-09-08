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
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Rule;

import java.util.List;

public class FuzzyModel {

    private static FIS model;

    public static FIS getModel() {
        if (model == null) {
            InputStream in = FuzzyModel.class.getResourceAsStream("apple_model.fcl"); 
            model = FIS.load(in, true);
            return model;
        } else {
            return model;
        }
    }

    private static void evaluateModel(
            double size, double redLevel, double spots) {
        FIS fuzzyModel = getModel();
        fuzzyModel.setVariable("size", size);
        fuzzyModel.setVariable("red_color", redLevel);
        fuzzyModel.setVariable("spots", spots);
        fuzzyModel.evaluate();
    }

    public static double getQuality(
            double size, double redColor, double spots) {
        evaluateModel(size, redColor, spots);
        return getModel().getVariable("quality").getLatestDefuzzifiedValue();
    }

    public static List<Rule> getRules(
            double size, double redColor, double spots) {
        evaluateModel(size, redColor, spots);
        return getModel()
                .getFunctionBlock("quality")
                .getFuzzyRuleBlock("No1")
                .getRules();
    }
    
    public static double getOutputLowMembership(
        double size, double redColor, double spots){
        evaluateModel(size, redColor, spots);
        return getModel()
                .getVariable("quality")
                .getMembership("low");
    }
    
    public static double getOutputMediumMembership(
        double size, double redColor, double spots){
        evaluateModel(size, redColor, spots);
        return getModel()
                .getVariable("quality")
                .getMembership("medium");
    }
    
    public static double getOutputPremiumMembership(
        double size, double redColor, double spots){
        evaluateModel(size, redColor, spots);
        return getModel()
                .getVariable("quality")
                .getMembership("premium");
    }
}
