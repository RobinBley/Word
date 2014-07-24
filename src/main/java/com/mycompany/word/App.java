package com.mycompany.word;

import com.mycompany.word.menue.Gui;

/**
 *
 * @author rbley
 */
public final class App {

    private App() {

    }

    public static void main(final String[] args) {
        Gui gui = new Gui();
        gui.createWindow();
        gui.showMenue();
        
//        PropertieManager.getInstance().getZuordnung().getMenue().showMenue();
        
        
    }

}
