/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import com.mycompany.word.menue.Gui;
import com.mycompany.word.propertiehandling.PropertieManager;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class MyFileBrowser extends JFrame implements Filebrowser {

    private final JList list;
    private final DefaultListModel listModel;
    private static MyFileBrowser instance = null;

    public static MyFileBrowser getInstance() {
        if (instance == null) {
            instance = new MyFileBrowser();
        }
        return instance;
    }

    public MyFileBrowser() {
        setTitle("CHOOSE FILE");
        setLayout(new BorderLayout());
        listModel = new DefaultListModel();
        setLocationRelativeTo(null);
        list = new JList(listModel);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PropertieManager.getInstance().changePropertie("filename", (String) listModel.get(list.getSelectedIndex()));
                PropertieManager.getInstance().getZuordnung().getPath().setFilename((String) listModel.get(list.getSelectedIndex()));
                setVisible(false);
                Gui.getInstance().showMenue();

            }
        });
        add(new JLabel("Choose file:"), BorderLayout.NORTH);
        add(list, BorderLayout.SOUTH);
        pack();
    }

    @Override
    public void showFiles() {
        ArrayList<String> files = PropertieManager.getInstance().getZuordnung().getReader().showFiles(PropertieManager.getInstance().getZuordnung().getPath().getFiledirectory());
        if (files != null) {
            setVisible(true);
            for (String file : files) {
                if (file.equals(files.get(0)) && listModel.getSize() > 0) {
                    break;
                }
                listModel.addElement(file);
            }
        } else {
            setVisible(false);
        }
        pack();

    }
}
