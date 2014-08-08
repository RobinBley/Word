/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.menu;

import de.bley.word.assignment.Zuordnung;
import de.bley.word.propertiehandling.PropertieManager;
import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.stereotype.Service;

/**
 * Bildet eine Consolen Oberflaeche.
 *
 * @author rbley
 * 
 */
@Service
public class Menue implements MenueInterface {

    private Zuordnung zuordnung;

    /**
     * Komponenten des Programms werden geladen.
     */
    protected void showFiles(Scanner scan) {
        final ArrayList<String> files = zuordnung.getReader().showFiles(zuordnung.getPath().getFiledirectory());
        int counter = 0;

        zuordnung.getEingabe().showFile();
        if (files != null) {
            for (String file : files) {
                zuordnung.getAusgabe().ausgeben(counter + " = " + file);
                counter++;
            }
            boolean run;
            if (counter > 0) {
                run = true;
            } else {
                run = false;
            }
            while (run) {
                final int input = scan.nextInt();
                if (input <= files.size() - 1) {
                    zuordnung.getPath().setFilename(files.get(input));
                    run = false;

                } else {
                    System.out.println("Falsche Eingabe");
                    run = false;

                }
            }
        }
    }

    protected void readFile() {
        zuordnung.getAusgabe().ausgeben("\n" + zuordnung.getReader().readFile(zuordnung.getPath().getFilepath()));
    }

    protected void writeFrile(final Scanner scan) {
        try {
            zuordnung.getAusgabe().ausgeben("output:");
            String output = scan.next();
            zuordnung.getWriter().writeInFile(zuordnung.getPath().getFilepath(), output, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Die Oberflaeche startet in der Console.
     */
    @Override
    public void showMenue() {
        zuordnung = PropertieManager.getInstance().getZuordnung();
        boolean run = true;

        final Scanner scan = new Scanner(System.in);
        while (run) {

            try {
                showFiles(scan);

                zuordnung.getEingabe().readFile();
                final int input = scan.nextInt();

                switch (input) {
                    case 0:
                        readFile();
                        break;
                    case 1:
                        writeFrile(scan);
                        break;
                    default:
                        run = false;
                        break;
                }
            } catch (Exception e) {
                run = false;

            }

        }
    }

}
