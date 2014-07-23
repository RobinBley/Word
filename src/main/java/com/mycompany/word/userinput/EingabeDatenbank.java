/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.word.userinput;

import org.springframework.stereotype.Service;

@Service
public class EingabeDatenbank implements Eingabe {
    @Override
    public void showFile(){
        System.out.println("\n0=reade\n1=write");
    }
    @Override
    public void readFile(){
        
    }
    
}
