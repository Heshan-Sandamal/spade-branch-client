/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.Customer;
import com.d2s2.spade.models.CustomerTelephone;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Heshan Sandamal
 */
public class CustomerController {
    
    //add customer to database
    public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();       //get connection from singleton dbConnection class
        
        String customerId=customer.getCustomerId();
        String name=customer.getName();
        String address=customer.getAddress();
        ArrayList<CustomerTelephone> telList=customer.getTelNoList();
        
        try {
            connection.setAutoCommit(false);        //disabling the autocommiting feature
            String sqlCustomer=DBQueryGenerator.insertQuery(Customer.class.getSimpleName(), 3);             //build insert query
            int setData = DBHandler.setData(connection, sqlCustomer,new Object[]{customerId,name,address});           //set data to customerTable
            
           
            if(setData>0){              //check customer data is added
                
                for (CustomerTelephone customerTelephone : telList) {
                    
                    
                    String sqlTelephone=DBQueryGenerator.insertQuery(CustomerTelephone.class.getSimpleName(), 2);       //use this way to get db table name.because model name is same as db table name
                    
                    //add data using prepared statements.refer handler class
                    int addedTel = DBHandler.setData(connection, sqlTelephone,new Object[]{customerTelephone.getCustomerId(),customerTelephone.getTelNo()});
                    
                    if(addedTel<=0){            //check customer telephone data is added
                        connection.rollback();      //if error then rool back
                        return false;
                    }
                }
                
            }else{
                connection.rollback();      //if error then rool back
                return false;
            }
            
            connection.commit();        //when no error commit 
            return true;
            
        } catch (Exception e) {
            connection.rollback();      //if error then rool back
            throw e;
        }finally{
            connection.setAutoCommit(true);     //enabling auto commit
        }
         
    }
    
}
