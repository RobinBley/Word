/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.filereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class ReaderImpl implements Reader {

   
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }
    private BufferedReader bufferedReader;
    private FileReader fileReader;
    @Autowired
    private String filepath;

    @Override
    public ArrayList<String> readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
        } catch (FileNotFoundException ex) {
        }
        
        try {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException ex) {
        }
        return null;
    }

    @Override
    public ArrayList<String> showFiles() {
        
        return null;

    }

}
