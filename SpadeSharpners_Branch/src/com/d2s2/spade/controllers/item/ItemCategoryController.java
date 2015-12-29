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
import java.sql.SQLException;

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
        
        Object[] ob=new Object[]{itemCode,itemCategory};
        
        return DBHandler.setData(connection, sql,ob)>0 ? true:false;
        
    }
    
}
