/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.word.filewriter;

import com.mycompany.word.connection.JdbcConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author rbley
 */
@Service
public class WriterJdbc implements Writer {

    private final static transient Logger log = Logger.getLogger(WriterJdbc.class);
//
//    public void createTable(String tablename) {
//        Connection connection = JdbcConnection.getInstance().connect();
//        if (connection != null) {
//            try {
////                String sql = "CREATE TABLE TextDatein" + "(inhalt VARCHAR(255)" + "PRIMARY KEY (inhalt))";
////                Statement stmt = connection.createStatement();
////                stmt.executeQuery(sql);
//
//                PreparedStatement ps = connection.prepareStatement("CREATE TABLE ?" + "(inhalt VARCHAR(255)" + "PRIMARY KEY (inhalt))");
//                ps.setString(1, tablename);
//                ps.executeQuery();
//                connection.close();
//            } catch (SQLException ex) {
//                log.debug("execute of Query", ex);
//
//            }
//        }
//
//    }

    @Override
    public void writeInFile(String col, String text, boolean flag) {

        Connection connection = JdbcConnection.getInstance().connect();

        if (connection != null) {
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO APP.MYTABLE (DATA) VALUES (?)");
                ps.setString(1, text);
                ps.executeUpdate();
                connection.close();
            } catch (SQLException ex) {
                log.debug("execute of Query", ex);
            }
        }
    }

}
