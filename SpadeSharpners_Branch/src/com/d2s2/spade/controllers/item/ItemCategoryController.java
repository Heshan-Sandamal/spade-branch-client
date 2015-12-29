/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers.item;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.ItemCategory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Heshan Sandamal
 */
public class ItemCategoryController {
    
    
    public static boolean addItemCategory(ItemCategory itemCategory) throws ClassNotFoundException, SQLException{
        
        Connection connection=DBConnection.getDBConnection().getConnection();
        String sql=DBQueryGenerator.insertQuery(ItemCategory.class.getSimpleName(), 2);
        
        String itemCode=itemCategory.getItemCode();
        String category=itemCategory.getCategory();
        
        Object[] ob=new Object[]{itemCode,category};
        
        return DBHandler.setData(connection, sql,ob)>0 ? true:false;
        
    }

    public static ArrayList<ItemCategory> getAllItemCategories() throws ClassNotFoundException, SQLException {
        Connection connection=DBConnection.getDBConnection().getConnection();
        String sql=DBQueryGenerator.selectAllQuery(ItemCategory.class.getSimpleName());
        ResultSet resultSet=DBHandler.getData(connection, sql);
        
        ArrayList<ItemCategory> categoryList=new ArrayList<>();
        
        while(resultSet.next()){
            
            String itemCode=resultSet.getString(ItemCategory.ITEMCODE);
            String category=resultSet.getString(ItemCategory.CATEGORY);
            categoryList.add(new ItemCategory(itemCode,category));
            
        }
        
        return categoryList;
    }
    
}
