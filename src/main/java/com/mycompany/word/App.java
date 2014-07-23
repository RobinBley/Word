package com.mycompany.word;

import com.mycompany.word.propertiehandling.PropertieManager;

/**
 *
 * @author rbley
 */
public final class App {

    private App() {

    }

    public static void main(final String[] args) {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
        PropertieManager.getInstance().getZuordnung().getMenue().showMenue();
        

    }

}
