/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.aenderer;

//import org.springframework.stereotype.Service;

/**
 * Dient dazu einen String zum UpperCase zu veraendern.
 *
 * @author rbley
 */
//@Service
public class UpperCaseAenderer implements Aenderer {

    private String lala;

    /**
     *
     * @param text String, welcher veraendert werden soll.
     * @return der als parameter uebergebene String als Uppercase
     */
    @Override
    public String textAendern(String text) {
        String hallo;
        return text.toUpperCase();

    }

}
