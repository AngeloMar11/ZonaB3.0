package org.ZonaBarber.webapp.util;

import java.sql.*;

//import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DbConnetion {


    public class DBconnection {

        private static final String URL = "jdbc:mysql://localhost/zonbar?serverTimezone=America/Bogota";
        private static final String USERNAME = "root";
        private static final String PASSWORD = null;

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
    }
}
