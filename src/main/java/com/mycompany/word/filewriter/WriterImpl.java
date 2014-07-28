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

@Service
public class WriterImpl implements Writer {
    
    private final static transient Logger log = Logger.getLogger(WriterJdbc.class);
    
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

                    if (!line.trim().equals(text))  {

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

    }
