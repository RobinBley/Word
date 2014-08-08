/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bley.word.components;

import javax.swing.JToolBar;

/**
 *
 * @author rbley
 * @deprecated 
 */
public class ToolBar {
    
    JToolBar toolbar;

    public ToolBar() {
        toolbar = new JToolBar();
    }
    
    
    
    
    public JToolBar getToolBar(){
        
        return toolbar;
    }
    
}
