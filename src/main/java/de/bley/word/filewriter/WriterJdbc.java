/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.filewriter;

import de.bley.word.connection.JdbcConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * Schreibt Datensaetze in eine JDBC Datenbank.
 *
 * @author rbley
 */
@Service
public class WriterJdbc implements Writer {

    private final static transient Logger log = Logger.getLogger(WriterJdbc.class);

    /**
     *
     * Schreibt einen Datensatz in eine Tabelle.
     *
     * @param col
     * @param text
     * @param flag
     *
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
     * Loescht eine Zeile einer Tabelle.
     *
     * @param filepath
     * @param text
     * @param row
     *
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
     * Ueberschreibt eine Datenbanktabelle.
     *
     * @param filepath Ungenutzer Parameter des Interfaces.
     * @param text Inhalt, womit die Tabelle ueberschrieben werden soll.
     *
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
