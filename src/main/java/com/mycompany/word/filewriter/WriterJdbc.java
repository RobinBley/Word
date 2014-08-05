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
 * @see Schreibt Datensaetze in eine JDBC Datenbank
 */
@Service
public class WriterJdbc implements Writer {

    private final static transient Logger log = Logger.getLogger(WriterJdbc.class);

    /**
     *
     * @param col
     * @param text
     * @param flag
     *
     * Schreibt einen Datensatz in eine Tabelle
     */
    @Override
    public void writeInFile(final String col, final String text, final boolean flag) {

        Connection connection = JdbcConnection.getInstance().connect();

        if (connection != null) {
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO APP.MYTABLE (DATA) VALUES (?)");
                ps.setString(1, text);
                ps.executeUpdate();
                connection.close();
            } catch (SQLException ex) {
                log.debug("execute of Query (write in file)", ex);
            }
        }
    }

    /**
     *
     * @param filepath
     * @param text
     * @param row
     *
     * Loescht eine Zeile einer Tabelle
     */
    @Override
    public void removeValue(final String filepath, final String text, final int row) {

        Connection connection = JdbcConnection.getInstance().connect();

        if (connection != null) {
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM APP.MYTABLE WHERE CAST(DATA AS VARCHAR(128)) = ?");
                ps.setString(1, text);
                ps.executeUpdate();
                connection.close();
            } catch (SQLException ex) {
                log.debug("execute of Query (remove value)", ex);
            }
        }

    }

    /**
     *
     * @param filepath
     * @param text
     *
     * ueberschreibt einen Table
     */
    @Override
    public void overwriteFile(String filepath, String text) {
        //Falsche implementation!!!
        Connection connection = JdbcConnection.getInstance().connect();
        writeInFile(filepath, text, true);

        if (connection != null) {
            try {
                PreparedStatement ps = connection.prepareStatement("TRUNCATE TABLE APP.MYTABLE");
                ps.executeUpdate();
                for (String line : text.split(System.getProperty("line.separator"))) {
                    ps = connection.prepareStatement("INSERT INTO APP.MYTABLE (DATA) VALUES (?)");
                    ps.setString(1, line);
                    ps.executeUpdate();

                }

                connection.close();
            } catch (SQLException ex) {
                log.debug("execute of Query (remove value)", ex);
            }
        }

    }

}
