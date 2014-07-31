/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.menue;

import com.mycompany.word.assignment.Zuordnung;
import com.mycompany.word.propertiehandling.PropertieManager;
import components.MenuBarPanel;
import components.MenuPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        setLocationRelativeTo(null);

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

    private void addListener() {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zuordnung.getWriter().overwriteFile(zuordnung.getPath().getFilepath(), textfield.getText());
                refreshList();
            }
        });

        textfield.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    zuordnung.getWriter().overwriteFile(zuordnung.getPath().getFilepath(), textfield.getText());
                }
            }
        });

    }
}
