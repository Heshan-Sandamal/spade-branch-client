/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers.item;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.Kiyath;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Heshan Sandamal
 */
public class KiyathController {

    public static boolean addItem(Kiyath kiyath) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.insertQuery(Kiyath.class.getSimpleName(), 3);


        try {
            connection.setAutoCommit(false);
            
            Object[] ob=new Object[]{kiyath.getCode(),kiyath.getSize(),kiyath.getNoOfTips()};
            boolean itemDetailAdded = ItemController.addItem(kiyath);
            if (itemDetailAdded) {
                boolean kiyathAdded=DBHandler.setData(connection, sql, ob) > 0 ? true : false;
                if(kiyathAdded){
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
