/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers.item;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.Cutter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Heshan Sandamal
 */
public class CutterController {
    public static boolean addItem(Cutter cutter) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.insertQuery(Cutter.class.getSimpleName(),4);


        try {
            connection.setAutoCommit(false);
            
            Object[] ob=new Object[]{cutter.getCode(),cutter.getSize(),cutter.getNoOfTips(),cutter.getThickness()};
            boolean itemDetailAdded = ItemController.addItem(cutter);
            if (itemDetailAdded) {
                boolean cutterAdded=DBHandler.setData(connection, sql, ob) > 0 ? true : false;
                if(cutterAdded){
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
