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
    private static PropertieManager instance = null;
    private final transient Properties props;
    private final transient ClassPathXmlApplicationContext ctx;

    public static PropertieManager getInstance() {
        synchronized (PropertieManager.class) {

            if (instance == null) {
                instance = new PropertieManager();
            }
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
            if (props.containsKey("zuordnung")) {
                final String zdg = props.getProperty("zuordnung");

                if (zdg.contains("bank") || zdg.contains("jdbc")) {
                    zuordnung = (Zuordnung) ctx.getBean("zuordnungJdbc");

                } else if (zdg.contains("file") || zdg.contains("impl") || zdg.contains("txt")) {
                    zuordnung = (Zuordnung) ctx.getBean("zuordnungImpl");
                } else {
                    zuordnung = (Zuordnung) ctx.getBean("zuordnungImpl");
                }
            } else {
                props.setProperty("zuordnung", "zuordnungImpl");
                zuordnung = (Zuordnung) ctx.getBean("zuordnungImpl");
            }
            try {
                if (props.containsKey("menue")) {
                    final String menuename = props.getProperty("menue");

                    if (menuename.contains("gui") || menuename.contains("gra")) {
                        zuordnung.setMenue(ctx.getBean(Gui.class));
                    } else if (menuename.contains("con") || menuename.contains("men")) {
                        zuordnung.setMenue(ctx.getBean(Menue.class));
                    } else {
                        zuordnung.setMenue(ctx.getBean(Gui.class));
                    }
                } else {
                    props.setProperty("menue", "gui");
                    zuordnung.setMenue(ctx.getBean(Gui.class));
                }

            } catch (BeansException e) {
                LOG.fatal("falsche menue propertie " + e);
            }
        } catch (BeansException e) {
            LOG.fatal("falsche zuordnung propertie " + e);
            zuordnung = (Zuordnung) ctx.getBean("zuordnungImpl");
        }
        return zuordnung;
    }

    public String[] getMenufields() {

        return props.getProperty("menuefelder").split(",");

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
