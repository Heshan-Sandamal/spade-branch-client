/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.d2s2.spade.controllers.item;

import com.d2s2.spade.dbconnection.DBConnection;
import com.d2s2.spade.dbconnection.DBHandler;
import com.d2s2.spade.dbconnection.DBQueryGenerator;
import com.d2s2.spade.models.Tip;
import com.d2s2.spade.models.Wheel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Heshan Sandamal
 */
public class WheelController {
    public static boolean addItem(Wheel wheel) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql = DBQueryGenerator.insertQuery(Wheel.class.getSimpleName(), 5);


        try {
            connection.setAutoCommit(false);
            
            Object[] ob=new Object[]{wheel.getCode(),wheel.getSize(),wheel.getCountry(),wheel.getDiameter(),wheel.getHole()};
            boolean itemDetailAdded = ItemController.addItem(wheel);
            if (itemDetailAdded) {
                boolean wheelAdded=DBHandler.setData(connection, sql, ob) > 0 ? true : false;
                if(wheelAdded){
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

    public static Wheel getDetailsOfItem(String code)throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql=DBQueryGenerator.selectLimitedColumnswhereQuery(new String[]{Wheel.SIZE,Wheel.COUNTRY,Wheel.DIAMETER,Wheel.HOLE},Wheel.class.getSimpleName(), Wheel.CODE);
        ResultSet data = DBHandler.getData(connection, sql,new Object[]{code});
        data.next();
        return new Wheel(data.getString(Wheel.SIZE),data.getString(Wheel.COUNTRY),data.getDouble(Wheel.DIAMETER),data.getDouble(Wheel.HOLE));
    }

    public static boolean updateItem(Wheel wheel) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
