/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers.item;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.Brand;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Heshan Sandamal
 */
public class BrandController {

    public static boolean addBrandCategory(Brand brand) throws ClassNotFoundException, SQLException{
        
        Connection connection=DBConnection.getDBConnection().getConnection();
        String sql=DBQueryGenerator.insertQuery(Brand.class.getSimpleName(), 2);
        
        String brandId=brand.getBrandId();
        String brandName=brand.getBrand();        
        Object[] ob=new Object[]{brandId,brandName};
        
        return DBHandler.setData(connection, sql,ob)>0 ? true:false;
        
    }
    
    
    public static ArrayList<Brand> getAllBrands() throws ClassNotFoundException, SQLException{
        
        Connection connection=DBConnection.getDBConnection().getConnection();
        String sql=DBQueryGenerator.selectAllQuery(Brand.class.getSimpleName());
        ResultSet resultSet=DBHandler.getData(connection, sql);
        
        ArrayList<Brand> brandList=new ArrayList<>();
        
        while(resultSet.next()){
            
            String brandId=resultSet.getString(Brand.BRANDID);
            String brand=resultSet.getString(Brand.BRAND);
            brandList.add(new Brand(brandId,brand));
            
        }
        
        return brandList;
        
    }
    
    
    
    
}
