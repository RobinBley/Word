/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.components;

import de.bley.word.menu.GuiMenu;
import de.bley.word.propertiehandling.PropertieManager;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

/**
 * Ein Component der Oberflache, welche das Menu bildet.
 *
 * @author rbley
 *
 */
//@Service
public class MenuBarPanel implements ActionListener, MenuPanel {

    private JPanel menuPanel;
    private JMenu options;
    private JMenu help;
    private JMenuBar menubar;
    private JMenuItem info;
    private JMenuItem menu;
    private JMenu submenu;
    private JMenuItem database;
    private JMenuItem file;
    private JMenuItem save;
//    private JMenuItem table;

    /**
     * Komponenten werden initialisiert.
     */
    public MenuBarPanel() {

        menuPanel = new JPanel(new BorderLayout());
        addMenus();
        addItems();
        menuPanel.add(menubar, BorderLayout.WEST);

    }

    private void addItems() {
        menu = new JMenuItem("change file");
        menu.addActionListener(this);
        options.add(menu);
        info = new JMenuItem("info");
        info.addActionListener(this);
        help.add(info);
        save = new JMenuItem("Save");
        save.addActionListener(this);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        options.add(save);
//        table = new JMenuItem("choose table");
//        table.addActionListener(this);
//        options.add(table);

        //Submenue
        submenu = new JMenu("data from..");
        options.add(submenu);

        //SubmenueItems
        database = new JMenuItem("database");
        database.addActionListener(this);
        submenu.add(database);

        file = new JMenuItem("file");
        file.addActionListener(this);
        submenu.add(file);

    }

    private void addMenus() {
        options = new JMenu("options");
        help = new JMenu("help");
        menubar = new JMenuBar();
        menubar.add(options);
        menubar.add(help);
    }

    /**
     *
     * @return JMenuBar, welche vollstaendig initialisiert wurde.
     */
    @Override
    public JMenuBar getMenuBar() {

        return menubar;
    }

    @Override
    public void actionPerformed(ActionEvent object) {
        if (object.getSource() == info) {
            JPopupMenu pop = new JPopupMenu();
            pop.add(new JLabel("Datenbank, kann kein file auswaehlen"));
            pop.show(menubar, 0, 0);

        } else if (object.getSource() == file) {
            PropertieManager.getInstance().changePropertie("zuordnung", "file");
            GuiMenu.getInstance().showMenue();
            menu.setEnabled(true);

        } else if (object.getSource() == database) {
            PropertieManager.getInstance().changePropertie("zuordnung", "datenbank");
            GuiMenu.getInstance().showMenue();
            disenabledFilechooser();
        } else if (object.getSource() == menu) {
//            MyFileBrowser.getInstance().showFiles();
            // JFileChooser-Objekt erstellen
            final JFileChooser chooser = new JFileChooser();
            // Dialog zum Oeffnen von Dateien anzeigen
            final int opt = chooser.showOpenDialog(null);

            if (opt == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                PropertieManager.getInstance().changePropertie("filename", file.getName());
                PropertieManager.getInstance().getZuordnung().getPath().setFilename(file.getName());
                String[] splitPath = file.getAbsolutePath().split("/");
                StringBuilder buffer = new StringBuilder();
                for (int i = 0; i < splitPath.length; i++) {
                    buffer.append("/").append(splitPath[i]);
                    if (i == splitPath.length - 2) {
                        break;
                    }
                }
                PropertieManager.getInstance().changePropertie("filedirectory", buffer.toString());
                PropertieManager.getInstance().getZuordnung().getPath().setFiledirectory(buffer.toString());
            }
            GuiMenu.getInstance().refreshList();

        } else if (object.getSource() == save) {
            GuiMenu.getInstance().saveData();
        }//else if (object.getSource() == table){
//            
//        }
    }

    /**
     * "Graut" die Option aus eine Datei auszuwaehlen.
     */
    @Override
    public void disenabledFilechooser() {
        menu.setEnabled(false);
    }

}
