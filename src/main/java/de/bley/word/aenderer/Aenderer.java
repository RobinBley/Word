/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.aenderer;

/**
 * Dient dazu einen String zu veraendern.
 * @author rbley
 *
 */
public interface Aenderer {

    /**
     *
     * @param text String, welcher veraendert werden soll.
     * @return Ein veraenderter String.
     */
    String textAendern(String text);

}
