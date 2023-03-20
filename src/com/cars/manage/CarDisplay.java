package com.cars.manage;

import java.sql.*;
import java.util.Scanner;

public class CarDisplay {

    public static void displayCar(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cars");
            if(!resultSet.isBeforeFirst()){
                System.out.println("We don't have any new cars right now!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nVehicle Identification NUmber : %s\nModel name : %s\nBrand : %s\nColor : %s\nPrice : %f\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5));

                }
                connection.close();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void displayOldCar(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select model_number,brand,color,sellingPrice,vin from old_cars");
            if(!resultSet.isBeforeFirst()){
                System.out.println("We don't have any old cars right now!!");
            }
            else {
                while (resultSet.next())
                {
                    System.out.printf("\n\nModel name : %s\nBrand : %s\nColor : %s\nPrice : %f\nvehicle identification number : %s\n",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getFloat(4),resultSet.getString(5));

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
