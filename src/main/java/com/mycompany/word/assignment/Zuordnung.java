/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.assignment;

import com.mycompany.word.Ausgabe.Ausgabe;
import com.mycompany.word.filereader.Reader;
import com.mycompany.word.filewriter.Writer;
import com.mycompany.word.menue.Menue;
import com.mycompany.word.paths.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
@Service
public class Zuordnung {

    @Autowired
    private Writer writer;
    @Autowired
    private Reader reader;
    @Autowired
    private Path path;
    @Autowired
    private Ausgabe ausgabe;
    @Autowired
    private Menue menue;

    public Menue getMenue() {
        return menue;
    }

    public void setMenue(Menue menue) {
        this.menue = menue;
    }


    public Ausgabe getAusgabe() {
        return ausgabe;
    }

    public void setAusgabe(Ausgabe ausgabe) {
        this.ausgabe = ausgabe;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

}
