/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.assignment;

import com.mycompany.word.ausgabe.Ausgabe;
import com.mycompany.word.filereader.Reader;
import com.mycompany.word.filewriter.Writer;
import com.mycompany.word.menue.Menue;
import com.mycompany.word.paths.Path;
import com.mycompany.word.userinput.Eingabe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
@Service
public class ZuordnungImpl implements Zuordnung {

    @Autowired
    @Qualifier("writerImpl")
    private Writer writer;
    @Autowired
    @Qualifier("readerImpl")
    private Reader reader;
    @Autowired
    @Qualifier("pathImpl")
    private Path path;
//    @Autowired
    private Ausgabe ausgabe;
    @Autowired
    private Menue menue;
    @Autowired
    @Qualifier("eingabeImpl")
    private Eingabe eingabe;

    @Override
    public Menue getMenue() {
        return menue;
    }

    @Override
    public void setMenue(Menue menue) {
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
