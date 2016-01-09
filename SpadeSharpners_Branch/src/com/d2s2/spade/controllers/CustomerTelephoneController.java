/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.CustomerTelephone;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tdiluksha
 */
public class CustomerTelephoneController {
    
    public static boolean addCustomerTelephone(CustomerTelephone customerTelephone){
        //
        
        //DBHandler.setData(null, null)
        return true;
    }
    
    public static ArrayList<CustomerTelephone> getCustomersTelephoneNo() throws SQLException, ClassNotFoundException{
        ArrayList<CustomerTelephone> telephoneArray = new ArrayList<>();
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.selectAllQuery("CustomerTelephone");
        ResultSet resultSet = DBHandler.getData(connection, sql);
        
        while (resultSet.next()) {
            String customerId = resultSet.getString(CustomerTelephone.CUSTOMERID);
            String teleNo = resultSet.getString(CustomerTelephone.TELNO);
            telephoneArray.add(new CustomerTelephone(customerId, teleNo));
        }
        return telephoneArray;
    }
    
}
