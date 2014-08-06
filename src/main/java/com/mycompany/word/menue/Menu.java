/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.menue;

import com.mycompany.word.assignment.Zuordnung;
import com.mycompany.word.filewriter.WriterJdbc;
import com.mycompany.word.propertiehandling.PropertieManager;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 *
 * Bildet eine Consolen Oberflaeche.
 *
 * @author rbley
 */
//@Service
public class Menu {

    private final static transient Logger log = Logger.getLogger(WriterJdbc.class);
    Zuordnung zuordnung;

    /**
     * Komponenten des Programms werden geladen.
     */
    public Menu() {
        zuordnung = PropertieManager.getInstance().getZuordnung();
    }

    private void readData() {
        final ArrayList<String> files = zuordnung.getReader().showFiles(zuordnung.getPath().getFiledirectory());

        if (files != null) {
            zuordnung.getAusgabe().ausgeben("Daten:");
            for (String file : files) {
                zuordnung.getAusgabe().ausgeben(file);
            }
        } else {
            zuordnung.getAusgabe().ausgeben("keine Daten");
        }
        zuordnung.getReader().readFile(zuordnung.getPath().getFilepath());

    }

    private void writeData(Scanner scan) {
        zuordnung.getAusgabe().ausgeben("Output String:");
        zuordnung.getWriter().writeInFile(zuordnung.getPath().getFilepath(), scan.next(), true);

    }

    /**
     * Die Oberflaeche startet in der Console.
     */
    public void showMenue() {

        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();

        // 0 = read......1=write
        boolean run = true;
        while (run) {
            switch (input) {

                case 0:
                    readData();
                    break;
                case 1:
                    writeData(scan);
                    break;
                default:
                    run = false;
                    break;

            }
        }

    }

}
