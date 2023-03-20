package com.cars.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SoldCarDisplay {
    public static void displaySoldCarsList(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from sold_cars_list");
            if(!resultSet.isBeforeFirst()){
                System.out.println("We haven't sold any cars right now!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nCustomer Id : %s\nVehicle Identification Number : %s\n", resultSet.getInt(1), resultSet.getString(2));

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void displaySoldCarDetails(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from soldcars_details");
            if(!resultSet.isBeforeFirst()){
                System.out.println("We haven't sold any cars right now!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nModel name : %s\nBrand : %s\nColor : %s\nPrice : %f\nVehicle Identification NUmber : %s\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getFloat(4), resultSet.getString(5));

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
