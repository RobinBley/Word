/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.menu;

import de.bley.word.assignment.Zuordnung;
import de.bley.word.assignment.JdbcZuordnung;
import de.bley.word.propertiehandling.PropertieManager;
import de.bley.word.components.MenuBarPanel;
import de.bley.word.components.MenuPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.springframework.stereotype.Service;

/**
 * Zeigt ein Graphical User Interface.
 *
 * @author rbley
 */
@Service
public class GuiMenu extends JFrame implements MenueInterface {

    private final JPanel panel;
    private final JButton button;
    private Zuordnung zuordnung;
    private final MenuPanel menuPanel;
    private final JTextArea textfield;
    private static GuiMenu instance = null;

    /**
     *
     * @return Eine Instanz der eigenen Klasse.
     */
    public static GuiMenu getInstance() {
        if (instance == null) {
            instance = new GuiMenu();
        }
        return instance;
    }

    /**
     * Kmponenten der Oberflaeche werden Initialisiert.
     */
    public GuiMenu() {
        instance = this;
        setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width / 4, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        setLocationRelativeTo(null);
        menuPanel = new MenuBarPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);
        textfield = new JTextArea();
        panel.add(textfield);
        JScrollPane scr = new JScrollPane(textfield, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(scr);
        button = new JButton();
        button.setText("Save");
        addListener();

    }

    /**
     * Erstellt das Fenster der Oberflaeche.
     */
    public void createWindow() {
        zuordnung = PropertieManager.getInstance().getZuordnung();
        setTitle("Oberflaeche");
        setJMenuBar(menuPanel.getMenuBar());
        getContentPane().add(panel);
        if (zuordnung.getClass().equals(JdbcZuordnung.class)) {
            menuPanel.disenabledFilechooser();
        }

    }

    /**
     * Laed den Inhalt der Oberflaeche neu.
     */
    public void refreshList() {
        textfield.setText(PropertieManager.getInstance().getZuordnung().getReader().readFile(zuordnung.getPath().getFilepath()));

    }

    /**
     * Zeigt die Oberflache.
     */
    @Override
    public void showMenue() {
        createWindow();
        refreshList();
        setVisible(true);

    }

    /**
     * Sorgt fuer das Speichern der eigegebenen Daten.
     */
    public void saveData() {
        zuordnung.getWriter().overwriteFile(zuordnung.getPath().getFilepath(), textfield.getText());
    }

    private void addListener() {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
                refreshList();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                if (!textfield.getText().equals("") && !textfield.getText().equals(PropertieManager.getInstance().getZuordnung().getReader().readFile(zuordnung.getPath().getFilepath()))) {

                    int confirmed = JOptionPane.showConfirmDialog(null, "Daten speichern?", "Beenden", JOptionPane.YES_NO_OPTION);

                    if (confirmed == JOptionPane.YES_OPTION) {
                        saveData();
                    }
                }
            }
        });

    }
}
