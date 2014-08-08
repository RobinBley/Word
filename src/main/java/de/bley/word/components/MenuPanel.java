/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.components;

import javax.swing.JMenuBar;

/**
 *
 * Bildet das Menu einer Oberflaeche.
 *
 * @author rbley
 */
public interface MenuPanel {

    JMenuBar getMenuBar();

    void disenabledFilechooser();

}
