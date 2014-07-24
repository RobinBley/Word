/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.assignment;

import com.mycompany.word.ausgabe.Ausgabe;
import com.mycompany.word.filereader.Reader;
import com.mycompany.word.filewriter.Writer;
import com.mycompany.word.menue.MenueInterface;
import com.mycompany.word.paths.Path;
import com.mycompany.word.userinput.Eingabe;

/**
 *
 * @author rbley
 */
public interface Zuordnung {

    MenueInterface getMenue();

    void setMenue(MenueInterface menue);

    Ausgabe getAusgabe();

    void setAusgabe(Ausgabe ausgabe);

    Writer getWriter();

    void setWriter(Writer writer);

    Reader getReader();

    void setReader(Reader reader);

    Path getPath();

    void setPath(Path path);

    Eingabe getEingabe();

    void setEingabe(Eingabe eingabe);

}
