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
    private final JButton button;
    private final JTextField textfield;
    private final JList list;
    private Zuordnung zuordnung;
    private final JPopupMenu pop;
//    private JMenuBar menubar;

    public Gui() {
        pop = new JPopupMenu();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new FlowLayout());
        panel.setBackground(Color.white);
        textfield = new JTextField(8);
        textfield.setText("Hier eingeben");
        panel.add(textfield);
        list = new JList(listModel);
        panel.add(list);
        button = new JButton();
        button.setText("Hinzufuegen");
        panel.add(button);
        addListener();
        
        /////////////////
//        menubar = new JMenuBar();
//        addMenuefields();
        /////////////////
    }
    /////////////////////////////////////////////////
//    private void addMenuefields(){
//        for(String field : PropertieManager.getInstance().getMenufields()){
//            System.out.println(field);
//            menubar.add(new JMenu("dddddddd"));
//            panel.add(menubar, FlowLayout.LEFT);
//        }
//    }
    /////////////////////////////////////////////////

    public void createWindow() {
        zuordnung = PropertieManager.getInstance().getZuordnung();
        setTitle("Oberflaeche");
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);

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
    

    private void addListener() {
        JButton popButton = new JButton();
        popButton.setText("remove");
        popButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                zuordnung.getWriter().removeValue(zuordnung.getPath().getFilepath(), (String) listModel.get(list.getSelectedIndex()), list.getSelectedIndex());
                refreshList();
                pop.setVisible(false);
            }
        });
        pop.add(popButton);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zuordnung.getWriter().writeInFile(zuordnung.getPath().getFilepath(), textfield.getText(), true);
                refreshList();
//                pop.setVisible(false);
            }
        });
        textfield.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textfield.setText("");
//                pop.setVisible(false);
            }
        });
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pop.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                pop.setVisible(false);
            }
        });
    }
}
