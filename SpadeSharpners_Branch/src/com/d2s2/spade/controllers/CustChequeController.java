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
        String sql = DBQueryGenerator.selectLimitedColumnswhereQuery(new String[]{CustCheque.BANK, CustCheque.CHEQUENO, CustCheque.EXPIRYDATE,
            CustCheque.ISSUEDATE, CustCheque.PAYMENTID, CustCheque.STATUS}, CustCheque.class.getSimpleName(), CustCheque.PAYMENTID);
        ResultSet resultSet = DBHandler.getData(connection, sql, new Object[]{paymentID});
        resultSet.next();
        
        if (resultSet.next()) {
            custCheque = new CustCheque();
            custCheque.setBank(resultSet.getString(CustCheque.BANK));
            custCheque.setChequeNo(resultSet.getString(CustCheque.CHEQUENO));

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            custCheque.setExpiryDate(Date.valueOf(resultSet.getString(CustCheque.EXPIRYDATE)));
            custCheque.setIssueDate(Date.valueOf(resultSet.getString(CustCheque.ISSUEDATE)));
            custCheque.setPaymentId(resultSet.getString(CustCheque.PAYMENTID));
            custCheque.setStatus(resultSet.getString(CustCheque.STATUS));
        }
        return custCheque;
    }
}
