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
    public static boolean addSupplier(Supplier supplier) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();       //get connection from singleton dbConnection class
        
        String supplierId=supplier.getSupplierId();
        String name=supplier.getName();
        String address=supplier.getAddress();
        String email = supplier.getEmail();
        

        String sqlSupplier=DBQueryGenerator.insertQuery(Supplier.class.getSimpleName(), 4);   
        Object[] ob=new Object[]{supplierId, name, address, email};
        return DBHandler.setData(connection, sqlSupplier,ob)>0 ? true:false;//build insert query
            
    }  
    public static boolean addSupplierTelephone(SupplierTelephone supplierTelephone) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();       //get connection from singleton dbConnection class
        
        String supplierId=supplierTelephone.getSupplierId();
        String Contactname=supplierTelephone.getContactName();
        String telephoneNumber=supplierTelephone.getTelNo();
       
        

        String sqlSupplierTelephone=DBQueryGenerator.insertQuery(SupplierTelephone.class.getSimpleName(), 3);   
        Object[] ob=new Object[]{supplierId, Contactname, telephoneNumber};
        return DBHandler.setData(connection, sqlSupplierTelephone,ob)>0 ? true:false;//build insert query
        
        
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
