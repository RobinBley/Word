package com.mycompany.word;

import com.mycompany.word.assignment.Zuordnung;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author rbley
 */
public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        Zuordnung zdg = (Zuordnung)ctx.getBean("zuordnung");
        zdg.getMenue().showMenue();

        
    }

}
