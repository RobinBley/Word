/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.word.popup;

import com.mycompany.word.filewriter.Writer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPopupMenu;

/**
 *
 * @author rbley
 */
public class PopMenu extends JPopupMenu {
    
    private String value;
    private Writer writer;

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
    public PopMenu() {
        JButton button = new JButton("remove");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.toString());
                System.out.println(value);
//                writer.removeValue(null, value, );
                
            }
        });
        
        add(button);
        
    }
    
}
