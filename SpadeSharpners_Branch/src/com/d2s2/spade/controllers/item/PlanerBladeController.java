/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers.item;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.PlanerBlade;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Heshan Sandamal
 */
public class PlanerBladeController {
    
    public static boolean addItem(PlanerBlade planerBlade) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.insertQuery(PlanerBlade.class.getSimpleName(), 3);


        try {
            connection.setAutoCommit(false);
            
            Object[] ob=new Object[]{planerBlade.getCode(),planerBlade.getSize(),planerBlade.getType()};
            boolean itemDetailAdded = ItemController.addItem(planerBlade);
            if (itemDetailAdded) {
                boolean planerBladeAdded=DBHandler.setData(connection, sql, ob) > 0 ? true : false;
                if(planerBladeAdded){
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

    public static PlanerBlade getDetailsOfItem(String code) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql=DBQueryGenerator.selectLimitedColumnswhereQuery(new String[]{PlanerBlade.TYPE,PlanerBlade.SIZE},PlanerBlade.class.getSimpleName(), PlanerBlade.CODE, code);
        ResultSet data = DBHandler.getData(connection, sql);
        data.next();
        return new PlanerBlade(data.getString(PlanerBlade.TYPE),data.getString(PlanerBlade.SIZE));
    }

}
