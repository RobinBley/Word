/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.ausgabe;

/**
 *
 * @author rbley
 *
 */
public interface Ausgabe {

    /**
     *
     * Gibt einen String ueber ein Medium aus.
     *
     * @param output String, welcher ausgegeben werden soll.
     * @return true, wenn die Ausgabe erfolgreich war.
     */
    boolean ausgeben(String output);

}
