/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.dbconnection;


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
    
    public static String selectAllQuery(String tableName){
        return "SELECT * FROM "+tableName;
    }
    
    public static String selectwhereQuery(String tableName, String columnName){
        return "SELECT * FROM "+tableName+" WHERE " +columnName+"= ?" ;
    }
    
}
