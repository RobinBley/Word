/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.word.filewriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriterImpl implements Writer {
    private String filename;
    private String diractory;
    private String filepath;

    @Override
    public void writeInFile() {
        
            
        File file = new File("TextDokumente");
        if(!file.exists()){
            file.mkdir();
        }
        
        
        
        try {
            BufferedWriter writer =new BufferedWriter(new FileWriter(diractory+"/"+filename));
            writer.write("moin");
            writer.close();
            
            
        } catch (IOException ex) {
        }
    }



    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDiractory() {
        return diractory;
    }

    public void setDiractory(String diractory) {
        this.diractory = diractory;
    }
    
}
