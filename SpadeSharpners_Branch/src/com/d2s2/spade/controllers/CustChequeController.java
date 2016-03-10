/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.CustCheque;
import com.d2s2.spade.models.CustDebt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Sineth
 */
public class CustChequeController {

    public static CustCheque getChequeDetails(String paymentID) throws ClassNotFoundException, SQLException {
        CustCheque custCheque=null;
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.selectwhereQuery("CustCheque","paymentId");
        ResultSet resultSet = DBHandler.getData(connection,sql,new Object[]{paymentID});

        if (resultSet.next()) {
            custCheque = new CustCheque();
            custCheque.setBank(resultSet.getString(CustCheque.BANK));
            custCheque.setChequeNo(resultSet.getString(CustCheque.CHEQUENO));

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            custCheque.setExpiryDate(Date.valueOf(resultSet.getString(CustCheque.EXPIRYDATE)));
            custCheque.setIssueDate(Date.valueOf(resultSet.getString(CustCheque.ISSUEDATE)));
            custCheque.setPaymentId(resultSet.getString(CustCheque.PAYMENTID));
            custCheque.setStatus(resultSet.getString(CustCheque.STATUS));
            System.out.println("Bank"+custCheque.getBank());
        }
        return custCheque;
    }
    
    public static boolean addCheque(CustCheque cc) throws ClassNotFoundException, SQLException{
        
        Connection connection = DBConnection.getDBConnection().getConnection();
        String insertQuery = DBQueryGenerator.insertQuery(CustCheque.class.getSimpleName(), 6);
        int affectedRows = DBHandler.setData(connection, insertQuery,new Object[]{cc.getPaymentId(),cc.getChequeNo(),cc.getBank(),cc.getExpiryDate(),cc.getIssueDate(),cc.getStatus()});
        return affectedRows!=0;
        
    }
    public static boolean deleteCheque(String paymenntID) throws ClassNotFoundException, SQLException{
        
        Connection connection = DBConnection.getDBConnection().getConnection();
        String deleteQuery = DBQueryGenerator.deleteQuery(CustCheque.class.getSimpleName(), CustCheque.PAYMENTID);
        int deleteData = DBHandler.deleteData(connection, deleteQuery, new Object[]{paymenntID});
        return deleteData!=0;
    }

}
