/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.filereader;

import com.mycompany.word.connection.JdbcConnection;
import com.mycompany.word.filewriter.WriterJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * liefert den Inhalt einer JDBC Datenbank.
 *
 * @author rbley
 */
@Service
public class ReaderJdbc implements Reader {

    private final static transient Logger log = Logger.getLogger(WriterJdbc.class);

    /**
     *
     * @param table Tabellenname.
     * @return Inhalt des Angegebenen Datenbanktabels.
     */
    @Override
    public String readFile(String table) {
        Connection connection = JdbcConnection.getInstance().connect();
        StringBuilder buffer = new StringBuilder();

        if (connection != null) {
            try {
//                String sql = "CREATE TABLE TextDatein" + "(inhalt VARCHAR(255)" + "PRIMARY KEY (inhalt))";
//                Statement stmt = connection.createStatement();
//                stmt.executeQuery(sql);

//                PreparedStatement ps = connection.prepareStatement("select * from APP.?");
//                ps.setString(1, table);
                PreparedStatement ps = connection.prepareStatement("Select * from App.MyTable");
                ResultSet result = ps.executeQuery();
                boolean run = true;
                while (run) {
                    if (result.next()) {
                        buffer.append(result.getString(1)).append("\n");
                    } else {
                        run = false;
                    }
                }
                connection.close();
                return buffer.toString();
            } catch (SQLException ex) {
                log.debug("execute of Query", ex);
            }
        }
        return null;
    }

    /**
     *
     * @param table Tabellenname.
     * @return null.
     */
    @Override
    public ArrayList<String> showFiles(String table) {
//        Connection connection = JdbcConnection.getInstance().connect();
//        ArrayList<String> data = new ArrayList<>();
//
//        if (connection != null) {
//            try {
//                //GET TABLE NAMES
//                PreparedStatement ps = connection.prepareStatement("Select * from App.MyTable");
//
//                ResultSet result = ps.executeQuery();
//                boolean run = true;
//                while (run) {
//                    if (result.next()) {
//                        data.add(result.getString(1));
//                    } else {
//                        run = false;
//                        log.debug("no result");
//                    }
//                }
//                connection.close();
//                return data;
//            } catch (SQLException ex) {
//                log.debug("execute of Query", ex);
//            }
//        }
        return null;

    }
}
