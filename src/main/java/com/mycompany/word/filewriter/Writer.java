/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.filewriter;

/**
 *
 * @author rbley
 */
public interface Writer {

    void writeInFile(String filepath, String text, boolean flag);

    void removeValue(String filepath, String text, int row);

}
