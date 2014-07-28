/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.menue;

import com.mycompany.word.assignment.Zuordnung;
import com.mycompany.word.propertiehandling.PropertieManager;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
@Service
public class Gui extends JFrame implements MenueInterface {

    private final DefaultListModel listModel = new DefaultListModel();
    private final JPanel panel;
    private JLabel label;
    private final JButton button;
    private final JTextField textfield;
    private final JList list;
    private Zuordnung zuordnung;
    private final JPopupMenu pop;

    public Gui() {
        pop = new JPopupMenu();
//        setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width / 4, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new FlowLayout());
        panel.setBackground(Color.white);
//        label = new JLabel();
//        label.setText("Eingabe:");
//        panel.add(label);
        textfield = new JTextField(8);
        textfield.setText("Hier eingeben");
        panel.add(textfield);
        list = new JList(listModel);

        panel.add(list);

        button = new JButton();
        button.setText("Hinzufuegen");
        panel.add(button);
//        button.setBackground(Color.white);
        addListener();
    }

    public void createWindow() {
        zuordnung = PropertieManager.getInstance().getZuordnung();
        setTitle("Oberflaeche");
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);

    }

    public void addToList(String text) {
        listModel.addElement(text);
    }

    public void setLabelText(String text) {
        label.setText(text);
    }

    void popMenu() {
        pop.setLocation(MouseInfo.getPointerInfo().getLocation());
        pop.setVisible(true);
    }

    public void refreshList() {
        listModel.removeAllElements();
        String[] split = zuordnung.getReader().readFile(zuordnung.getPath().getFilepath()).split(System.getProperty("line.separator"));
        for (String row : split) {
            listModel.addElement(row);
        }
        pack();
    }

    @Override
    public void showMenue() {
        createWindow();
        refreshList();
        setVisible(true);
    }

    public void addListener() {
        JButton popButton = new JButton();
        popButton.setText("remove");
        popButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zuordnung.getWriter().removeValue(zuordnung.getPath().getFilepath(), (String) listModel.get(list.getSelectedIndex()), list.getSelectedIndex());
                System.out.println((String) listModel.get(list.getSelectedIndex()));
                refreshList();
            }
        });
        pop.add(popButton);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                zuordnung.getWriter().writeInFile(zuordnung.getPath().getFilepath(), textfield.getText(), true);
                if (textfield.getText() == "") {
                }
                refreshList();
                pop.setVisible(false);
            }
        });
        textfield.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textfield.setText("");
                pop.setVisible(false);
            }
        });
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popMenu();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pop.setVisible(false);
            }
        });
//        list.addListSelectionListener(new ListSelectionListener() {
//
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                System.out.println(e.getFirstIndex());
//
//            }
//        });
    }
}
