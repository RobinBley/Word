/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.menue;

import com.mycompany.word.assignment.Zuordnung;
import com.mycompany.word.assignment.ZuordnungJdbc;
import com.mycompany.word.propertiehandling.PropertieManager;
import components.MenuBarPanel;
import components.MenuPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
@Service
public class Gui extends JFrame implements MenueInterface {

    private final JPanel panel;
    private final JButton button;
//    private final JTextField textfield;
    private Zuordnung zuordnung;
//    @Autowired
//    @Qualifier("MenuBarPanel")
    private MenuPanel menuPanel;
    private JTextArea textfield;

    private static Gui instance = null;

    public static Gui getInstance() {
        if (instance == null) {
            instance = new Gui();
        }
        return instance;
    }

    public Gui() {
        setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width / 4, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        setLocationRelativeTo(null);
        instance = this;

        menuPanel = new MenuBarPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);

        textfield = new JTextArea();
        panel.add(textfield);
        button = new JButton();
        button.setText("Save");
//        panel.add(button, BorderLayout.SOUTH);
        addListener();
        
        
        
        
    }

    public void createWindow() {
        zuordnung = PropertieManager.getInstance().getZuordnung();
        setTitle("Oberflaeche");
        setJMenuBar(menuPanel.getMenuBar());
        getContentPane().add(panel);
        if (zuordnung.getClass().equals(ZuordnungJdbc.class)) {
            menuPanel.disenabledFilechooser();
        }


    }

    public void refreshList() {
        textfield.setText(PropertieManager.getInstance().getZuordnung().getReader().readFile(zuordnung.getPath().getFilepath()));

    }

    @Override
    public void showMenue() {
        createWindow();
        refreshList();
        setVisible(true);

    }
    public void saveData(){
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
            public void windowClosing(WindowEvent e) {

                if (!textfield.getText().equals(PropertieManager.getInstance().getZuordnung().getReader().readFile(zuordnung.getPath().getFilepath()))) {

                    int confirmed = JOptionPane.showConfirmDialog(null,
                            "Speichern der Daten?", "Beenden",
                            JOptionPane.YES_NO_OPTION);

                    if (confirmed == JOptionPane.YES_OPTION) {
                        saveData();

                        dispose();
                    } else {
                        dispose();
                    }
                }
            }
        });

    }
}
