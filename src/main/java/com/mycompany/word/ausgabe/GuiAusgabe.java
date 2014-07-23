/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.word.ausgabe;

import com.mycompany.word.Gui;
import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
@Service
public class GuiAusgabe implements Ausgabe{

    @Override
    public boolean ausgeben(String output) {
        Gui.getInstance().addToList(output);
        return true;
    }
    
    
}
