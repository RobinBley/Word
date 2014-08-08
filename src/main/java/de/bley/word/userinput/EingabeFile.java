/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.userinput;

import de.bley.word.propertiehandling.PropertieManager;
import org.springframework.stereotype.Service;

@Service
public class EingabeFile implements Eingabe {

    @Override
    public void showFile() {
        PropertieManager.getInstance().getZuordnung().getAusgabe().ausgeben("choose file:");
    }

    @Override
    public void readFile() {
        PropertieManager.getInstance().getZuordnung().getAusgabe().ausgeben("\n0=read file \n1=write into file\nelse=break");

    }
}
