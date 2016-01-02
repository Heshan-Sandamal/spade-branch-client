/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers.item;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.RouterCutter;
import com.d2s2.spade.models.Tip;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Heshan Sandamal
 */
public class TipController {
    public static boolean addItem(Tip tip) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.insertQuery(Tip.class.getSimpleName(), 4);


        try {
            connection.setAutoCommit(false);
            
            Object[] ob=new Object[]{tip.getCode(),tip.getSize(),tip.getCountry(),tip.getPrice()};
            boolean itemDetailAdded = ItemController.addItem(tip);
            if (itemDetailAdded) {
                boolean tipAdded=DBHandler.setData(connection, sql, ob) > 0 ? true : false;
                if(tipAdded){
                    connection.commit();
                    return true;
                }else{
                    connection.rollback();
                    return false;
                }

            }else{
                connection.rollback();
                return false;
            }

        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }


    }
}
