/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.dbconnection;

import com.d2s2.spade.models.Customer;

/**
 *
 * @author Heshan Sandamal
 */
public class DBQueryGenerator {
    
    
    
    public static String insertQuery(String tableName,int parameterCount){
        String sql="INSERT INTO "+tableName +" Values(";
        
        for (int i = 0; i < parameterCount; i++) {
            sql+="?";
            if(i!=parameterCount-1){
                sql+=",";
            }
            
        }
        return sql+")";
    }
    
    
    
    
}
