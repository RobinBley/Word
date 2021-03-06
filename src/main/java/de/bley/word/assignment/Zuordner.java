/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.bley.word.assignment;

import de.bley.word.ausgabe.Ausgabe;
import de.bley.word.filereader.Reader;
import de.bley.word.filewriter.Writer;
import de.bley.word.menu.MenueInterface;
import de.bley.word.paths.Path;
import de.bley.word.userinput.Eingabe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 * @deprecated 
 */
//@Service
public class Zuordner implements Zuordnung {
    @Autowired
    @Qualifier("writerJdbc")
    private Writer writer;
    @Autowired
    @Qualifier("readerJdbc")
    private Reader reader;
    @Autowired
    @Qualifier("pathDatabase")
    private Path path;
    @Autowired
    @Qualifier("consoleAusgabe")
    private Ausgabe ausgabe;
    @Autowired
    @Qualifier("guiMenu")
    private MenueInterface menue;

    private Eingabe eingabe;

    @Override
    public MenueInterface getMenue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMenue(MenueInterface menue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Writer getWriter() {
        return writer;
    }

    @Override
    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public Reader getReader() {
        return reader;
    }

    @Override
    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public Path getPath() {
        return path;
    }

    @Override
    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public Ausgabe getAusgabe() {
        return ausgabe;
    }

    @Override
    public void setAusgabe(Ausgabe ausgabe) {
        this.ausgabe = ausgabe;
    }

    /**
     *
     * @return
     */
    @Override
    public Eingabe getEingabe() {
        return eingabe;
    }

    @Override
    public void setEingabe(Eingabe eingabe) {
        this.eingabe = eingabe;
    }

}
