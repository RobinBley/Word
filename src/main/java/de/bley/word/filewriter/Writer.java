/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.filewriter;

/**
 *
 * Schreibt Daten in ein Medium.
 *
 * @author rbley
 */
public interface Writer {

    void writeInFile(String filepath, String text, boolean flag);

    void removeValue(String filepath, String text, int row);

    void overwriteFile(String filepath, String text);

}
