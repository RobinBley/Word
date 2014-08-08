/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.filewriter;

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
 * Schreibt Daten in eine Textdatei.
 *
 * @author rbley
 */
@Service
public class WriterFile implements Writer {

    private final static transient Logger log = Logger.getLogger(WriterJdbc.class);

    /**
     * Schreibt Daten in eine Textdatei.
     *
     * @param filepath Pfad der zulesenden Datei.
     * @param text String, welcher in die Datei geschrieben werden soll.
     * @param flag Boolean, ob Text angehangen oder ueberschrieben werden soll.
     *
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
     * loescht eine Zeile einer Textdatei.
     *
     * @param filepath Pfad der Datei.
     * @param text String, welcher aus der Datei geloescht werden soll.
     * @param row Zeile, welche geloescht werden soll.
     *
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
     * Ueberschreibt den Inhalt einer Textdatei.
     *
     * @param filepath Pfad der zulesenden Datei.
     * @param text String, welcher in die Datei geschrieben werden soll.
     *
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
