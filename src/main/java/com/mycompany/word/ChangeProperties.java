/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author rbley
 */
public class ChangeProperties {

    public static boolean changePropertie(String propertie, String value) {

        Properties props = new Properties();
        File f = new File("/home/rbley/NetBeansProjects/Word/src/main/resources/app.properties");
        try {
            props.load(new FileInputStream(f));
            OutputStream out = new FileOutputStream("/home/rbley/NetBeansProjects/Word/src/main/resources/app.properties", false);
            props.setProperty(propertie, value);
            props.store(out, null);

            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

    }

}
