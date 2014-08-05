/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.word.aenderer;

import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
@Service
public class AendererImpl implements Aenderer {

    private String lala;
    
    /**
     *
     * @param text
     * @return der als parameter uebergebene String als Uppercase
     */
    @Override
    public String textAendern(String text) {
        String hallo;
        return text.toUpperCase();
        
    }
    
}
