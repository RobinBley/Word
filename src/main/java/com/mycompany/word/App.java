package com.mycompany.word;

import com.mycompany.word.propertiehandling.PropertieManager;

/**
 *
 * @author rbley
 *
 *
 */
public final class App {

    private App() {

    }

    /**
     *
     * Die Hauptmethode startet das Programm, indem sie die Funktion showMenu()
     * eines Menus aufruft und somit das Userinterface oeffnet
     *
     *
     */
    public static void main(final String[] args) {
        PropertieManager.getInstance().getZuordnung().getMenue().showMenue();
    }

}
