/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.propertiehandling;

import com.mycompany.word.assignment.Zuordnung;
import com.mycompany.word.filereader.ReaderImpl;
import com.mycompany.word.menue.Gui;
import com.mycompany.word.menue.Menue;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author rbley
 */
public final class PropertieManager {

    private final transient static Logger LOG = Logger.getLogger(ReaderImpl.class);
    public static PropertieManager instance = null;
    private final Properties props;
    private final ClassPathXmlApplicationContext ctx;

    public static PropertieManager getInstance() {
        if (instance == null) {
            instance = new PropertieManager();
        }
        return instance;
    }

    public PropertieManager() {
        ctx = new ClassPathXmlApplicationContext("application-context.xml");

        props = new Properties();
        final InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties");
        try {
            props.load(inputStream);
        } catch (IOException ex) {
            LOG.debug("fehler beim laden der Properties", ex);
        }

    }

    public Zuordnung getZuordnung() {
        Zuordnung zuordnung;
        try {
            final String zdg = props.getProperty("zuordnung");
            if (zdg.contains("bank") || zdg.contains("jdbc")) {
                zuordnung = (Zuordnung) ctx.getBean("zuordnungJdbc");

            } else if (zdg.contains("file") || zdg.contains("impl") || zdg.contains("txt")) {
                zuordnung = (Zuordnung) ctx.getBean("zuordnungImpl");
            } else {
                zuordnung = (Zuordnung) ctx.getBean("zuordnungImpl");
            }
            try {

                final String menuename = props.getProperty("menue");

                if (menuename.contains("gui") || menuename.contains("gra")) {
                    zuordnung.setMenue(ctx.getBean(Gui.class));
                } else if (menuename.contains("con") || menuename.contains("men")) {
                    zuordnung.setMenue(ctx.getBean(Menue.class));
                }

                return zuordnung;
            } catch (BeansException e) {
                LOG.debug("falsche menue propertie (menue)" + e);
            }
        } catch (BeansException e) {
            LOG.debug("falsche menue propertie (zuordnung)" + e);
            zuordnung = (Zuordnung) ctx.getBean("zuordnungImpl");
        }
        return zuordnung;
    }

    public Properties getPropertie() {
        return props;
    }

    public void changePropertie(final String propertie, final String value) {

        try {
//            Thread.currentThread().getContextClassLoader("resources/app.properties");
            final OutputStream out = new FileOutputStream("/home/rbley/NetBeansProjects/Word/src/main/resources/app.properties", false);
            props.setProperty(propertie, value);
            props.store(out, null);

        } catch (IOException ex) {
            LOG.debug("fehler beim laden der Properties", ex);
        }

    }

}
