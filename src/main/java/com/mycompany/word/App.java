/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.word;

import com.mycompany.word.paths.Path;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author rbley
 */
public class App {
    
    public static void main(String[] args) {
        new App();
    }

    public App() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        System.out.println(((Path)ctx.getBean("path")).getFilepath());
 
        
    }
    
}
