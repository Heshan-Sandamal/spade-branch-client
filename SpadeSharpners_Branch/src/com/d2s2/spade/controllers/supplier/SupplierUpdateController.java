
package com.d2s2.spade.controllers.supplier;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.Supplier;
import com.d2s2.spade.models.SupplierBranch;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class SupplierUpdateController {
    public static boolean updateSupplier(Supplier oldSupplier, Supplier supplier) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();       //get connection from singleton dbConnection class

        String supplierId = supplier.getSupplierId();
        String name = supplier.getName();
        String email =supplier.getEmail();
       
        ArrayList<SupplierBranch> telList = supplier.getBranchContactList();

        try {
            connection.setAutoCommit(false);        //disabling the autocommiting feature
            String deletesql = DBQueryGenerator.deleteQuery(Supplier.class.getSimpleName(), "supplierId"); // build delete query
            String sqlCustomer = DBQueryGenerator.insertQuery(Supplier.class.getSimpleName(), 3);             //build insert query
            int deleteData = 0;
            deleteData = DBHandler.deleteData(connection, deletesql, new Object[]{oldSupplier.getSupplierId()});

            if (deleteData != 0) {
                int setData = DBHandler.setData(connection, sqlCustomer, new Object[]{supplierId, name,email });           //set data to customerTable

                if (setData > 0) {              //check customer data is added

                    for (SupplierBranch supplierBranch : telList) {

                        // CustomerTelephoneController.addCustomerTelephone(customerTelephone)
                        String sqlTelephone = DBQueryGenerator.insertQuery(SupplierBranch.class.getSimpleName(), 4);       //use this way to get db table name.because model name is same as db table name

                        //add data using prepared statements.refer handler class
                        int addedTel = DBHandler.setData(connection, sqlTelephone, new Object[]{ supplierBranch.getBranchName(),supplierBranch.getAddress(),supplierBranch.getContactName(),supplierBranch.getTelNo()});

                        if (addedTel <= 0) {            //check customer telephone data is added
                            connection.rollback();      //if error then rool back
                            return false;
                        }
                    }

                } else {
                    connection.rollback();      //if error in adding data then rool back
                    return false;
                }
            } else {
                connection.rollback();      //if error in deleting then rool back
                return false;
            }
            connection.commit();        //when no error commit 
            return true;

        } catch (Exception e) {
            connection.rollback();      //if error then rool back
            throw e;
        } finally {
            connection.setAutoCommit(true);     //enabling auto commit
        }

    }
    
}
