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
 * @author Dimuth Tharaka
 */
public class CustPaymentController {
    public static double getCustomerDebt(String customerID) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.selectwhereQuery(CustDebt.class.getSimpleName(), CustDebt.CUSTOMERID);
        ResultSet resultSet = DBHandler.getData(connection, sql,new Object[]{customerID});
        resultSet.next();
        return resultSet.getInt(CustDebt.AMOUNT);
    }
}
