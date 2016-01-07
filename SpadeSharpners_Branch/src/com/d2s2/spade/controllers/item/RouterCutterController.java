/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers.item;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.Kiyath;
import com.d2s2.spade.models.RouterCutter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Heshan Sandamal
 */
public class RouterCutterController {
    public static boolean addItem(RouterCutter routerCutter) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.insertQuery(RouterCutter.class.getSimpleName(), 2);


        try {
            connection.setAutoCommit(false);
            
            Object[] ob=new Object[]{routerCutter.getCode(),routerCutter.getSize()};
            boolean itemDetailAdded = ItemController.addItem(routerCutter);
            if (itemDetailAdded) {
                boolean routerCutterAdded=DBHandler.setData(connection, sql, ob) > 0 ? true : false;
                if(routerCutterAdded){
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

    public static RouterCutter getDetailsOfItem(String code) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql=DBQueryGenerator.selectLimitedColumnswhereQuery(new String[]{RouterCutter.SIZE},RouterCutter.class.getSimpleName(), RouterCutter.CODE);
        ResultSet data = DBHandler.getData(connection, sql,new Object[]{code});
        data.next();
        return new RouterCutter(data.getString(RouterCutter.SIZE));
    }

    public static boolean updateItem(RouterCutter routerCutter) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.updateQuery(new String[]{routerCutter.SIZE}, RouterCutter.class.getSimpleName(), routerCutter.CODE);


        try {
            connection.setAutoCommit(false);

            Object[] ob = new Object[]{routerCutter.getSize(),routerCutter.getCode()};
            boolean itemDetailAdded = ItemController.updateItem(routerCutter);
            if (itemDetailAdded) {
                boolean kiyathAdded = DBHandler.setData(connection, sql, ob) > 0 ? true : false;
                if (kiyathAdded) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    return false;
                }

            } else {
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
