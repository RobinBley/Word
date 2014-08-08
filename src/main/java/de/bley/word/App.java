package de.bley.word;

import de.bley.word.propertiehandling.PropertieManager;

/**
 * Hier wird das Programm gestartet.
 *
 * @author rbley
 *
 *
 */
public final class App {

    /**
     *
     * Die Hauptmethode startet das Programm, indem sie die Methode showMenu()
     * eines "Menu"s aufruft und somit das Userinterface oeffnet.
     *
     *
     * @param args
     */
    public static void main(final String[] args) {
        PropertieManager.getInstance().getZuordnung().getMenue().showMenue();
    }

}
