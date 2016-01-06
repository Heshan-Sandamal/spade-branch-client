/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Heshan
 */
public class DBConnection {

    private static DBConnection dbConnetion;
    private  Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.jdbc.Driver");

       connection = DriverManager.getConnection("jdbc:mysql://localhost/spadeBranchDB", "root", "12345");
       //connection = DriverManager.getConnection("jdbc:mysql://localhost/spadeBranchDB", "root", "diluksha");
        

    }

    public static DBConnection getDBConnection() throws ClassNotFoundException, SQLException {
        if (dbConnetion == null) {
            dbConnetion = new DBConnection();
        }
        return dbConnetion;
    }

    

    public Connection getConnection() {
        return connection;

    }
}
