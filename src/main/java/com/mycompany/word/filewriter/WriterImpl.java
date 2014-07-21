/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.filewriter;

import com.mycompany.word.paths.Path;
import com.mycompany.word.paths.PathImpl;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WriterImpl implements Writer {

    @Override
    public void writeInFile(String text, boolean flag) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        String filepath = ((Path) ctx.getBean(PathImpl.class)).getFilepath();

        try {
            FileWriter writer = new FileWriter(filepath, flag);
            writer.write(text);
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
