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
        if (model == null) {
            // TODO Implement .fcl
            String filePath = "src/model/apple_model.fcl";
            model = FIS.load(filePath);
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
}
