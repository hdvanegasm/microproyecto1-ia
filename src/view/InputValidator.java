/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.*;
/**
 *
 * @author pvillegasg
 */
public class InputValidator extends InputVerifier {
    
    public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        return !tf.getText().isEmpty();
    }
    
}
