/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.readdirectoy;

import com.mycompany.word.paths.Path;
import java.io.File;
import java.util.ArrayList;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class DirectoyreaderImpl implements Directoyreader {

    private String filepath;

    @Override
    public ArrayList<String> showFiles() {
        ArrayList<String> directory = new ArrayList<String>();
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        File file = new File(((Path) ctx.getBean("path")).getFilepath());
        File[] listOfFiles = file.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                directory.add(listOfFiles[i].getName());
              
            }
        }

        return directory;
    }

}
