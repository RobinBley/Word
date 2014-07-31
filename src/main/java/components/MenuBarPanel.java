/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import com.mycompany.word.menue.Gui;
import com.mycompany.word.propertiehandling.PropertieManager;
import java.awt.BorderLayout;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author rbley
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

    @Override
    public JMenuBar getMenuBar() {

        return menubar;
    }

    @Override
    public void actionPerformed(ActionEvent object) {
        if (object.getSource() == info) {
            JPopupMenu pop = new JPopupMenu();
            pop.add(new JLabel("Datenbank, kann kein file auswaehlen"));
            pop.show(menuPanel, 0, 0);

        } else if (object.getSource() == file) {
            PropertieManager.getInstance().changePropertie("zuordnung", "file");
            Gui.getInstance().showMenue();
            
        } else if (object.getSource() == database) {
            PropertieManager.getInstance().changePropertie("zuordnung", "datenbank");
            Gui.getInstance().showMenue();

        } else if (object.getSource() == menu) {
            MyFileBrowser.getInstance().showFiles();
        }

    }

}
