package com.mycompany.word;

import com.mycompany.word.assignment.Zuordnung;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author rbley
 */
public final class App {

    private App() {

    }

    public static void main(final String[] args) {
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        final Zuordnung zdg = (Zuordnung)ctx.getBean("zuordnungJdbc");
        zdg.getMenue().showMenue();

    }

}
