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
 * Enthaelt Komponenten des Programms, um den Umgang mit Datein zu ermoeglichen.
 *
 * @author rbley
 *
 */
@Service
public class FileZuordnung implements Zuordnung {

    @Autowired
    @Qualifier("writerFile")
    private Writer writer;
    @Autowired
    @Qualifier("readerFile")
    private Reader reader;
    @Autowired
    @Qualifier("filePath")
    private Path path;
    @Autowired
//    @Qualifier("guiAusgabe")
    private Ausgabe ausgabe;
    @Autowired
    @Qualifier("menue")
    private MenueInterface menue;
    @Autowired
    @Qualifier("eingabeFile")
    private Eingabe eingabe;

    @Override
    public MenueInterface getMenue() {
        return menue;
    }

    @Override
    public void setMenue(MenueInterface menue) {
        this.menue = menue;
    }

    @Override
    public Ausgabe getAusgabe() {
        return ausgabe;
    }

    @Override
    public void setAusgabe(Ausgabe ausgabe) {
        this.ausgabe = ausgabe;
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
    public Eingabe getEingabe() {
        return eingabe;
    }

    @Override
    public void setEingabe(Eingabe eingabe) {
        this.eingabe = eingabe;
    }

}
