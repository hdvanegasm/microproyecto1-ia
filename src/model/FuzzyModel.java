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

public class FuzzyModel {
    private static FIS model;
    
    public static FIS getModel() {
        if(model == null) {
            String filePath = "model.fcl";
            model = FIS.load(filePath);
            return model;
        } else {
            return model;
        }
    }
    
    public static double getQuality() {
        return 0;
    }
}
