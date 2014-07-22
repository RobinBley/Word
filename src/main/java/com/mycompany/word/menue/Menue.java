/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.menue;

import com.mycompany.word.configuration.Configuration;
import java.util.ArrayList;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
@Service
public class Menue {

    @Autowired
    private Configuration config;


    protected void showFiles(Scanner scan) {
        final ArrayList<String> files = config.getReader().showFiles(config.getPath().getFiledirectory());
        int counter = 0;
        System.out.println("choose file:");

        for (String file : files) {
            System.out.println(counter + "= " + file);
            counter++;
        }
        System.out.println("else= break");

        boolean run = true;
        while (run) {
            final int input = scan.nextInt();
            if (input <= files.size() - 1) {
                config.getPath().setFilename(files.get(input));
                run = false;

            } else {
                System.out.println("Falsche Eingabe");
                run = false;

            }
        }
    }

    protected void readFile() {
        System.out.println("\n" + config.getReader().readFile(config.getPath().getFilepath()));
    }

    protected void writeFrile(final Scanner scan) {
        try {
            System.out.println("output");
            String output = scan.next();
            System.out.println("Append?(boolean):");
            boolean flag = scan.nextBoolean();
            config.getWriter().writeInFile(config.getPath().getFilepath(), output, flag);
        } catch (Exception e) {
            System.out.println("Falsche Eingabe");
        }

    }

    public void showMenue() {
        boolean run = true;

        while (run) {

            final Scanner scan = new Scanner(System.in);

            try {
                showFiles(scan);

                System.out.println("\n0=read file \n1=write into file\nelse=break");

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
