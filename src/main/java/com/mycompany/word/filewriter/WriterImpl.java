/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.filewriter;

import java.io.FileWriter;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WriterImpl implements Writer {

    @Value("${filename}")
    String filename;

    @Value("$filedirectory")
    String filedirectory;

    String filepath;

    public WriterImpl() {
        filepath = filedirectory + filename;
    }

    @Override
    public void writeInFile(String filepath, String text, boolean flag) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        try {
            FileWriter writer = new FileWriter(filepath, flag);
            writer.write(text);
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
