/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ReaderImpl implements Reader {

    private final transient static Logger log = Logger.getLogger(ReaderImpl.class);
//    @Value("${filename}")
//    private String filename;
//
//    @Value("${filedirectory}")
//    private String filedirectory;
//    
//
//    public String getFilepath() {
//        return filedirectory + filename;
//    }
//
//    public String getFilename() {
//        return filename;
//    }
//
//    public void setFilename(String filename) {
//        this.filename = filename;
//    }
//
//    public String getFiledirectory() {
//        return filedirectory;
//    }
//
//    public void setFiledirectory(String filedirectory) {
//        this.filedirectory = filedirectory;
//    }

    @Override
    public String readFile(String filepath) {
        final StringBuilder builder = new StringBuilder();
        final File f = new File(filepath);
        if (f.exists()) {
            final BufferedReader bufferedReader;
            try {

                bufferedReader = new BufferedReader(new FileReader(filepath));
            } catch (FileNotFoundException ex) {
                log.fatal("Datei nicht gefunden " + filepath, ex);
                return "";
            }

            try {
                while (bufferedReader.ready()) {
                    builder.append(bufferedReader.readLine()).append("\n");
                }
            } catch (IOException ex) {
                log.fatal("IOException readFiles() ", ex);
            }
        }
        return builder.toString();
    }

    @Override
    public ArrayList<String> showFiles(String filepath) {
        final ArrayList<String> files = new ArrayList<>();
        final File f = new File(filepath);

        if (f.exists()) {
            File[] listOfFiles = f.listFiles();
            try {
                for (File fileOfList : listOfFiles) {
                    if (fileOfList.isFile()) {
                        files.add(fileOfList.getName());
                    }
                }
                return files;
            } catch (Exception e) {
                log.debug("Lesen der files fehlgeschlagen", e);
            }
        }
        return null;
    }
}
