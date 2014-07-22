/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.filewriter;

import java.io.FileWriter;
import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WriterImpl implements Writer {

    @Override
    public void writeInFile(String filepath, String text, boolean flag) {
        filepath = "/" + filepath;
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        try {
            final FileWriter writer = new FileWriter(filepath, flag);
            writer.write(text);
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
