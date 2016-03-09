/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.main;

import com.d2s2.spade.view.MainInterface;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author Heshan Sandamal
 */
public class SpadeSharpners_Branch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("starting the application");
        
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (Exception e) {
        }
        new MainInterface().setVisible(true);
    }
    
    
}
