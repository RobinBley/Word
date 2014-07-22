/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.propertiehandling;

import com.mycompany.word.filereader.ReaderImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author rbley
 */
public final class PropertieManager {

    private final transient static Logger LOG = Logger.getLogger(ReaderImpl.class);

    private PropertieManager() {
        
    }

    public static Properties getPropertie() {
        final Properties props = new Properties();
        File propertiefile;
        propertiefile = new File("/home/rbley/NetBeansProjects/Word/src/main/resources/app.properties");

        try {
            props.load(new FileInputStream(propertiefile));

        } catch (IOException ex) {
            LOG.debug("fileInputStream PrpertieManager", ex);
        }
        return props;
    }

    public static void changePropertie(final String propertie, final String value) {

        final Properties props = new Properties();
        File propertiefile;
        propertiefile = new File("/home/rbley/NetBeansProjects/Word/src/main/resources/app.properties");
        try {
            props.load(new FileInputStream(propertiefile));
            final OutputStream out = new FileOutputStream("/home/rbley/NetBeansProjects/Word/src/main/resources/app.properties", false);
            props.setProperty(propertie, value);
            props.store(out, null);

        } catch (IOException ex) {
            LOG.debug("fehler beim laden der Properties", ex);
        }

    }

}
