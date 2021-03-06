/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bley.word.connection;

import de.bley.word.filewriter.WriterJdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * Sorgt fuer die Verbindung zu einer JDBC Datenbank.
 *
 * @author rbley
 */
@Service
public class JdbcConnection {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String DB_URL = "jdbc:derby://localhost:1527/sample";
    private final static transient Logger log = Logger.getLogger(WriterJdbc.class);
    private static JdbcConnection instance = null;

    /**
     *
     * @return eine Instanz der eigenen Klasse.
     */
    public static JdbcConnection getInstance() {
        if (instance == null) {
            instance = new JdbcConnection();
        }
        return instance;
    }

    /**
     *
     * @return Eine Verbindung zu einer Datenbank.
     */
    public Connection connect() {
        try {

            Class.forName(JDBC_DRIVER).newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            log.fatal("Driver failed", e);
        }
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(DB_URL, "app", "app");
            return connection;

        } catch (SQLException e) {
            log.fatal("connection failed", e);
            return null;
        }
    }

}
