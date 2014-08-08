/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.propertiehandling;

import de.bley.word.assignment.Zuordnung;
import de.bley.word.assignment.FileZuordnung;
import de.bley.word.assignment.JdbcZuordnung;
import de.bley.word.menu.GuiMenu;
import de.bley.word.menu.Menue;
import de.bley.word.menu.ClickedGuiMenu;
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
 * Verwaltet die Properties und sorgt fuer die Zuordnungen der Componenten des
 * gesamten Programms.
 *
 * @author rbley
 */
public final class PropertieManager {

    private final transient static Logger LOG = Logger.getLogger(PropertieManager.class);
    private static PropertieManager instance = null;
    private final transient Properties props;
    private final transient ClassPathXmlApplicationContext ctx;

    /**
     *
     * @return Eine Istanz der eigenen Klasse.
     */
    public static PropertieManager getInstance() {
        synchronized (PropertieManager.class) {

            if (instance == null) {
                instance = new PropertieManager();
            }
        }
        return instance;
    }

    /**
     * Laed die Programm-Properties.
     */
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

    /**
     *
     * @return Die Richtige zusammensetzung einer Zuordnungsklasse.
     */
    public Zuordnung getZuordnung() {
        Zuordnung zuordnung;
        try {
            if (props.containsKey("zuordnung")) {

                final String zdg = props.getProperty("zuordnung");
                if (zdg.contains("bank") || zdg.contains("jdbc")) {
                    zuordnung = ctx.getBean(JdbcZuordnung.class);

                } else if (zdg.contains("file") || zdg.contains("impl") || zdg.contains("txt")) {
                    zuordnung = (Zuordnung) ctx.getBean("fileZuordnung");
                } else {
                    zuordnung = ctx.getBean(FileZuordnung.class);
                }
            } else {
                props.setProperty("zuordnung", "filezuordnung");
                zuordnung = ctx.getBean(FileZuordnung.class);
            }
            try {
                if (props.containsKey("menue")) {
                    final String menuename = props.getProperty("menue");

                    if (menuename.contains("gui") || menuename.contains("gra")) {
                        zuordnung.setMenue(ctx.getBean(GuiMenu.class));
                    } else if (menuename.contains("con") || menuename.contains("men")) {
                        zuordnung.setMenue(ctx.getBean(Menue.class));
                    } else if (menuename.contains("two")) {
                        zuordnung.setMenue(ClickedGuiMenu.getInstance());
                    } else {
                        zuordnung.setMenue(ctx.getBean(GuiMenu.class));
                    }
                } else {
                    props.setProperty("menue", "gui");
                    zuordnung.setMenue(ctx.getBean(GuiMenu.class));
                }

            } catch (BeansException e) {
                LOG.fatal("falsche menue propertie " + e);
            }
        } catch (BeansException e) {
            LOG.fatal("falsche zuordnung propertie " + e);
            zuordnung = ctx.getBean(FileZuordnung.class);
        }
        return zuordnung;
    }

    /**
     *
     * @return Optionen der Properties.
     */
    public String[] getMenufields() {

        return props.getProperty("menuefelder").split(",");

    }

    /**
     *
     * @return Aktuelle Programm-Properties.
     */
    public Properties getPropertie() {
        return props;
    }

    /**
     *
     * Aendert ein Wert eines Keys der Programm-Properties und speichert diese.
     *
     * @param propertie Schluessel der zu veraendernden Propertie.
     * @param value Wert, welche dem Schluessel zugeordnet werden soll.
     */
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
