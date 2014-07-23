package com.mycompany.word;

import com.mycompany.word.gui.Gui;

/**
 *
 * @author rbley
 */
public final class App {

    private App() {

    }

    public static void main(final String[] args) {
        Gui.getInstance();
//        PropertieManager.getInstance().getZuordnung().getMenue().showMenue();
        

    }

}
