/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers.item;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.Tip;
import java.sql.Connection;
import java.sql.ResultSet;
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

   

    public static Tip getDetailsOfItem(String code) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql=DBQueryGenerator.selectLimitedColumnswhereQuery(new String[]{Tip.SIZE,Tip.COUNTRY,Tip.PRICE},Tip.class.getSimpleName(), Tip.CODE);
        ResultSet data = DBHandler.getData(connection, sql,new Object[]{code});
        data.next();
        return new Tip(data.getString(Tip.SIZE),data.getString(Tip.COUNTRY),data.getDouble(Tip.PRICE));
    }

    public static boolean updateItem(Tip tip) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.updateQuery(new String[]{Tip.SIZE,Tip.COUNTRY,Tip.PRICE}, Tip.class.getSimpleName(), Tip.CODE);


        try {
            connection.setAutoCommit(false);

            Object[] ob = new Object[]{tip.getSize(),tip.getCountry(),tip.getPrice(),tip.getCode()};
            boolean itemDetailAdded = ItemController.updateItem(tip);
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
