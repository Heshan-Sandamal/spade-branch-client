/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.dbconnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Heshan
 */
public class DBHandler {
    public static int setData(Connection connection,String query,Object[] ob) throws SQLException{       
        PreparedStatement preparedStatement = 
                        connection.prepareStatement(query);
        for (int i = 0; i < ob.length; i++) {
            preparedStatement.setObject(i+1, ob[i]);
        }
        int res = preparedStatement.executeUpdate();
        return res;        
    }
    public static int setData(Connection connection,String query) throws SQLException{       
        PreparedStatement preparedStatement = 
                        connection.prepareStatement(query);
        int res = preparedStatement.executeUpdate();
        return res;        
    }
    
    public static int deleteData(Connection connection, String query, Object[] ob)throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        for (int i = 0; i < ob.length; i++) {
            preparedStatement.setObject(i+1, ob[i]);
        }
        int res = preparedStatement.executeUpdate();
        return res;
    }
    
    public static ResultSet getData(Connection connection,String query,Object[] ob) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        for (int i = 0; i < ob.length; i++) {
            preparedStatement.setObject(i+1, ob[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public static ResultSet getDataStatement(Connection connection,String query) throws SQLException{
        Statement stm=connection.createStatement();
        ResultSet resultSet = stm.executeQuery(query);
        return resultSet;
    }
    public static ResultSet getData(Connection connection,String query) throws SQLException{
        PreparedStatement preparedStatement = 
                        connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }    

    public static int setImageData(Connection connection, String query, String string, int x, FileInputStream inputStream, int y) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,string);
        preparedStatement.setInt(2,x);
        preparedStatement.setBinaryStream(3, inputStream, (int)y);
        int res = preparedStatement.executeUpdate();
        return res;
    }
    public static int updateImageData(Connection connection, String query, String string, int x, FileInputStream inputStream, int y) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(3,string);
        preparedStatement.setInt(1,x);
        preparedStatement.setBinaryStream(2, inputStream, (int)y);
        int res = preparedStatement.executeUpdate();
        return res;
    }
}
