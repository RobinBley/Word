/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import com.mycompany.word.propertiehandling.PropertieManager;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class MyFileBrowser extends JFrame implements Filebrowser {

    private final JList list;
    private final DefaultListModel listModel;

    public MyFileBrowser() {
        setTitle("CHOOSE FILE");
        setLayout(new BorderLayout());
        listModel = new DefaultListModel();
        setLocationRelativeTo(null);
        list = new JList(listModel);
        add(new JLabel("Choose file:"), BorderLayout.NORTH);
        add(list, BorderLayout.SOUTH);
        setVisible(true);
        pack();
    }

    @Override
    public void showFiles() {
        ArrayList<String> files = PropertieManager.getInstance().getZuordnung().getReader().showFiles(PropertieManager.getInstance().getZuordnung().getPath().getFiledirectory());
        for (String file : files) {
            if (file.equals(files.get(0)) && listModel.getSize() > 0) {
                break;
            }
            listModel.addElement(file);
            System.out.println(file);
        }
        pack();

    }
}
