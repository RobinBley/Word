/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.gui;

import com.mycompany.word.assignment.Zuordnung;
import com.mycompany.word.propertiehandling.PropertieManager;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author rbley
 */
public class Gui extends JFrame {

    private final DefaultListModel listModel = new DefaultListModel();
    private final JPanel panel;
    private final JLabel label;
    private final JButton button;
    private JTextField textfield;
    private final JList list;
    public static Gui instance;
    public Zuordnung zuordnung;

    public static Gui getInstance() {
        if (instance == null) {
            instance = new Gui();
        }
        return instance;
    }

    public Gui() {
        super("Oberflaeche");
        zuordnung = PropertieManager.getInstance().getZuordnung();
        setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width / 4, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new FlowLayout());
        panel.setBackground(Color.white);
        label = new JLabel();
        label.setText("Eingabe:");
//        panel.add(label);
        textfield = new JTextField(8);
        textfield.setText("Hier eingeben");
        panel.add(textfield);
        list = new JList(listModel);
        panel.add(list);
        button = new JButton();
        button.setText("Hinzufuegen");
        panel.add(button);
        getContentPane().add(panel);

        textfield.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textfield.setText("");
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMenue();
            }
        });
        refreshList();
        pack();
        setVisible(true);
    }

    public void addToList(String text) {
        listModel.addElement(text);
    }

    public void setLabelText(String text) {
        label.setText(text);
    }

    public void refreshList() {
        listModel.removeAllElements();
        String[] split = zuordnung.getReader().readFile(zuordnung.getPath().getFilepath()).split(System.getProperty("line.separator"));
        for (String row : split) {
            listModel.addElement(row);
        }
    }

    public void showMenue() {
        zuordnung.getWriter().writeInFile(zuordnung.getPath().getFilepath(), textfield.getText() + System.getProperty("line.separator"), true);
        refreshList();
        pack();
    }

}
