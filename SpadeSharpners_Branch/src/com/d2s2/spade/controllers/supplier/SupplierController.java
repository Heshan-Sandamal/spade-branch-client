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
import com.d2s2.spade.models.SupplierBranch;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dimuth Tharaka
 */
public class SupplierController {
    public static boolean addSupplier(Supplier supplier,ArrayList<SupplierBranch> supplierTelephoneList) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();       //get connection from singleton dbConnection class
        
        String supplierId=supplier.getSupplierId();
        
        String name=supplier.getName();
        
        String email = supplier.getEmail();
        ArrayList<SupplierBranch> telList = supplierTelephoneList;
        
        try{
            connection.setAutoCommit(false);  
            String sqlSupplier=DBQueryGenerator.insertQuery(Supplier.class.getSimpleName(), 3);
            
       
            int setData = DBHandler.setData(connection, sqlSupplier,new Object[]{supplierId,name,email});
            
            if(setData>0){              //check customer data is added
                
                for (SupplierBranch supplierTelephone : telList) {
                    
                    
                    String sqlTelephone=DBQueryGenerator.insertQueryBranch(SupplierBranch.class.getSimpleName());       //use this way to get db table name.because model name is same as db table name
                    
                    //add data using prepared statements.refer handler class
                    System.out.println(supplierTelephone.getAddress());
                    int addedTel = DBHandler.setData(connection, sqlTelephone,new Object[]{supplierTelephone.getSupplierId(),supplierTelephone.getBranchName(),
                        
                        supplierTelephone.getAddress(),supplierTelephone.getContactName(),supplierTelephone.getTelNo()});
                        
                    System.out.println("Here");
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
            
            String email = resultSet.getString(Supplier.EMAIL);
         
            supplierList.add(new Supplier(supplierId,name,email));
            
            //itemList.add(new Item(code,itemCode,subId,brandId,supplierId,salesType));     
        }
        
        return supplierList;
    }
    public static ArrayList<SupplierBranch> getSupplierContactInfo(String iDValue) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();
        String[] colums ={"branchName","BranchID","address","contactName","telNo"};
        String tableName="SupplierBranch";
        String beforeEquals="supplierID";
        
        String afterEquals=iDValue;
        Object[] ob={afterEquals};
        
        String sql=DBQueryGenerator.selectLimitedColumnswhereQuery(colums,tableName,beforeEquals);
        ResultSet resultSet=DBHandler.getData(connection, sql,ob);
        ArrayList<SupplierBranch> contactList=new ArrayList<SupplierBranch>();
        while(resultSet.next()){
            System.out.println(resultSet.getString(1));
            SupplierBranch supplierBranch =new SupplierBranch();
            
            supplierBranch.setAddress(resultSet.getString("address"));
            supplierBranch.setBranchName(resultSet.getString("branchName"));
            supplierBranch.setContactName(resultSet.getString("contactName"));
            supplierBranch.setTelNo(resultSet.getString("telNo"));
            supplierBranch.setBranchId(resultSet.getInt("branchId"));
            contactList.add(supplierBranch);
        }
        return contactList;
    }
    public static int removeSupplier(String ID) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getDBConnection().getConnection();
        int removeData= 0;
        try{
            String sql =DBQueryGenerator.deleteWhereQuery("supplier", "supplierID");
            connection.setAutoCommit(false);
            removeData=DBHandler.deleteData(connection, sql, new String[] {ID});
            if(removeData>0){
                System.out.println("Successfull");
            }
        }
        catch(Exception e){
            connection.rollback();      //if error then rool back
            throw e;
        }
        finally{
            connection.setAutoCommit(true);
        }
        return removeData;
    }
    public static int getLastSupplierId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = "SELECT branchId FROM supplierbranch ORDER BY branchId DESC LIMIT 1";
        ResultSet resultSet = DBHandler.getData(connection, sql);
        
        
        boolean s=resultSet.next();
        if(s){
             String str = resultSet.getString("branchid");
             int lastId= Integer.parseInt(str);
                return lastId+1;
        }
       
        else{
            System.out.println(s);
            return 1;
        }
       
        
    }
    
    
        
        
    }

