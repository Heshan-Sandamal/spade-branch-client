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
import com.d2s2.spade.models.CustPayment;
import com.d2s2.spade.models.paymentType;
import java.sql.Connection;
import java.sql.Date;
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

    public static boolean addPaymentInfo(CustPayment custPayment) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getDBConnection().getConnection();  
        String paymentId=custPayment.getPaymentId();
        String customerId=custPayment.getCustomerId();
        paymentType type=custPayment.getType();
        double discount=custPayment.getDiscount();
        double amount=custPayment.getAmount();
        Date date=custPayment.getDate();
        
        try{
            connection.setAutoCommit(false);
            String sqlAddPayment=DBQueryGenerator.insertQuery(CustPayment.class.getSimpleName(), 6);
            int rowsAffected=DBHandler.setData(connection, sqlAddPayment, new Object[]{paymentId,customerId,type,discount,amount,date});    
            if (rowsAffected>0) {
                // Success
                connection.commit();
                return true;
            }else{
               connection.rollback();      //if error then roll back
               return false;
            }
            
        } catch (Exception e) {
            connection.rollback();      //if error then roll back
            throw e;
        } finally {
            connection.setAutoCommit(true);     //enabling auto commit
        }
        
    }   
}
