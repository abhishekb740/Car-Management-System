package com.cars.manage;

import java.sql.*;

public class CarDeletion {

    public static boolean deleteCar(String vin){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="delete from cars where vin='"+vin+"'";
            statement.executeUpdate(query);

            res=true;
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public static boolean deleteOldCar(String vin){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="delete from old_cars where vin='"+vin+"'";
            statement.executeUpdate(query);

            res=true;
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
}
