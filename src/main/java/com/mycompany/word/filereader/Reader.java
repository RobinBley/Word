/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.filereader;

import java.util.ArrayList;

/**
 *
 * liest Daten aus einem Medium.
 *
 * @author rbley
 *
 */
public interface Reader {

    String readFile(String filepath);

    ArrayList<String> showFiles(String filepath);

}
