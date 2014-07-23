/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.ausgabe;

import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
//@Service
public class ConsoleAusgabe implements Ausgabe {

    @Override
    public boolean ausgeben(final String output) {
        try {
            System.out.println(output);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
