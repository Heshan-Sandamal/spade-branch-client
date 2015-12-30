/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers.item;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.RouterCutter;
import com.d2s2.spade.models.SilverSole;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Heshan Sandamal
 */
public class SilverSoleController {
    public static boolean addItem(SilverSole silverSole) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.insertQuery(SilverSole.class.getSimpleName(), 2);


        try {
            connection.setAutoCommit(false);
            
            Object[] ob=new Object[]{silverSole.getCode(),silverSole.getType(),silverSole.getPrice()};
            boolean itemDetailAdded = ItemController.addItem(silverSole);
            if (itemDetailAdded) {
                boolean silverSoleAdded=DBHandler.setData(connection, sql, ob) > 0 ? true : false;
                if(silverSoleAdded){
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
