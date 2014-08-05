/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.filewriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 * @see Schreibt daten in einer Textdatei
 */
@Service
public class WriterImpl implements Writer {

    private final static transient Logger log = Logger.getLogger(WriterJdbc.class);

    /**
     *
     * @param filepath
     * @param text
     * @param flag, ob Text angehangen oder ueberschrieben werden soll
     *
     * Schreibt Daten in eine Textdatei.
     */
    @Override
    public void writeInFile(String filepath, final String text, final boolean flag) {

        try {
            final FileWriter writer = new FileWriter(filepath, flag);
            writer.write(text + System.getProperty("line.separator"));
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param filepath
     * @param text
     * @param row
     *
     * loescht eine Zeile in einer Textdatei
     */
    @Override
    public void removeValue(String filepath, final String text, final int row) {
        filepath = "/" + filepath;

        File inFile = new File(filepath);
        File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
        BufferedReader br;
        int counter = 0;

        try {
            br = new BufferedReader(new FileReader(filepath));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //nur eine zeile loeschen
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(text)) {

                    pw.println(line);
                    pw.flush();
                }
                counter++;
            }
            pw.close();
            br.close();

            inFile.delete();

            tempFile.renameTo(inFile);

        } catch (Exception ex) {
            log.debug("fehler beim loeschen", ex);
        }
    }

    /**
     *
     * @param filepath
     * @param text
     *
     * Ueberschreibt eine Textdatei.
     */
    @Override
    public void overwriteFile(String filepath, String text) {

        try {
            FileWriter writer = new FileWriter(filepath, false);
            writer.write(text);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
