/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.filereader;

import com.mycompany.word.paths.Path;
import com.mycompany.word.paths.PathImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ReaderImpl implements Reader {

    @Override
    public String readFile() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        String filepath = ((Path) ctx.getBean(PathImpl.class)).getFilepath();
        StringBuilder builder = new StringBuilder();
        File f = new File(filepath);
        if (f.exists()) {
            BufferedReader bufferedReader = null;
            try {

                bufferedReader = new BufferedReader(new FileReader(filepath));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            try {
                while (bufferedReader.ready()) {
                    builder.append(bufferedReader.readLine() + "\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return builder.toString();
    }

    @Override
    public String showFiles() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        String filepath = ((Path) ctx.getBean(PathImpl.class)).getFiledirectory();
        StringBuilder builder = new StringBuilder();
        File f = new File(filepath);

        if (f.exists()) {
            File file = new File(filepath);
            File[] listOfFiles = file.listFiles();
            try {
                for (File fileOfList : listOfFiles) {
                    if (fileOfList.isFile()) {
                        builder.append(fileOfList.getName() + "\n");
                    }
                }
            } catch (Exception e) {
                
            }
        }
        return builder.toString();
    }
}
