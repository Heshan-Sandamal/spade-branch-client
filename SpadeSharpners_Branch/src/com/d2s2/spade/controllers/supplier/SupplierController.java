/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers.supplier;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.Supplier;
import com.d2s2.spade.models.CustomerTelephone;
import com.d2s2.spade.models.Item;
import com.d2s2.spade.models.SupplierTelephone;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dimuth Tharaka
 */
public class SupplierController {
    public static boolean addSupplier(Supplier supplier,ArrayList<SupplierTelephone> supplierTelephoneList) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();       //get connection from singleton dbConnection class
        
        String supplierId=supplier.getSupplierId();
        String name=supplier.getName();
        String address=supplier.getAddress();
        String email = supplier.getEmail();
        ArrayList<SupplierTelephone> telList = supplierTelephoneList;
        
        try{
            connection.setAutoCommit(false);  
            String sqlSupplier=DBQueryGenerator.insertQuery(Supplier.class.getSimpleName(), 4);
            int setData = DBHandler.setData(connection, sqlSupplier,new Object[]{supplierId,name,address,email});
            
            if(setData>0){              //check customer data is added
                
                for (SupplierTelephone supplierTelephone : telList) {
                    
                    
                    String sqlTelephone=DBQueryGenerator.insertQuery(SupplierTelephone.class.getSimpleName(), 3);       //use this way to get db table name.because model name is same as db table name
                    
                    //add data using prepared statements.refer handler class
                    int addedTel = DBHandler.setData(connection, sqlTelephone,new Object[]{supplierTelephone.getSupplierId(),
                        supplierTelephone.getContactName(),supplierTelephone.getTelNo()});
                    
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

        
            
     


    public static ArrayList<Supplier> getAllSuppliers() throws ClassNotFoundException, SQLException {
         
        Connection connection=DBConnection.getDBConnection().getConnection();
        String sql=DBQueryGenerator.selectAllQuery(Supplier.class.getSimpleName());
        ResultSet resultSet=DBHandler.getData(connection, sql);
        
        ArrayList<Supplier> supplierList=new ArrayList<>();
        
        while(resultSet.next()){
            
            String supplierId=resultSet.getString(Supplier.SUPPLIERID);
            String name=resultSet.getString(Supplier.NAME);
            
            supplierList.add(new Supplier(supplierId,name));
            
            //itemList.add(new Item(code,itemCode,subId,brandId,supplierId,salesType));     
        }
        
        return supplierList;
    }

    
}
