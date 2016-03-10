/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.CustDebt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sineth
 */
public class CustDebtController {

    public static void updateDebtInfo(CustDebt custDebt) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        try {
            connection.setAutoCommit(false);
            String sqlUpdateQuery = DBQueryGenerator.updateQuery(new String[]{CustDebt.AMOUNT}, CustDebt.class.getSimpleName(), CustDebt.CUSTOMERID);
            int affectedRows = DBHandler.setData(connection, sqlUpdateQuery, new Object[]{custDebt.getDebt(), custDebt.getCustomerId()});
            if (affectedRows > 0) {
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
    public static double getCustomerDebt(String customerID) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.selectAllQuery(CustDebt.class.getSimpleName());
        ResultSet resultSet = DBHandler.getData(connection, sql,new Object[]{customerID});
        resultSet.next();
        return resultSet.getInt(CustDebt.AMOUNT);
    }

}
