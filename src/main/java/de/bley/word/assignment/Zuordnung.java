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

/**
 *
 * Ein Zuordner enthaelt und sorgt fuer die gewuenschte Kombination von
 * Komponenten des Programms.
 *
 * @author rbley
 * 
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
