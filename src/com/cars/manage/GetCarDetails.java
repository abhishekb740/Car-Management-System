package com.cars.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class GetCarDetails {

    public static Car getCar_vin(String vin){
        Car car = new Car();
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from cars where vin ='"+vin+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found with this vin!!");
            }
            else {
                while (resultSet.next()) {
                    String modelName = resultSet.getString(1);
                    String brand = resultSet.getString(2);
                    String color = resultSet.getString(3);
                    float price = resultSet.getFloat(4);
                    String new_vin = resultSet.getString(5);
                    car.setModelNumber(modelName);
                    car.setBrand(brand);
                    car.setColor(color);
                    car.setVin(new_vin);
                    car.setPrice(price);

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return car;
    }
    public static Car getOldCar_vin(String vin){
        Car car = new Car();
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select model_number,brand,color,sellingPrice,vin from old_cars where vin ='"+vin+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found with this vin!!");
            }
            else {
                while (resultSet.next()) {
                    String modelName = resultSet.getString(1);
                    String brand = resultSet.getString(2);
                    String color = resultSet.getString(3);
                    float price = resultSet.getFloat(4);
                    String new_vin = resultSet.getString(5);
                    car.setModelNumber(modelName);
                    car.setBrand(brand);
                    car.setColor(color);
                    car.setVin(new_vin);
                    car.setPrice(price);

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return car;
    }
    public static float getPrice_vin(String vin){
        float price=0;
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select price from cars where vin ='"+vin+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found with this vin!!");
            }
            else {
                while (resultSet.next()) {
                    price = resultSet.getFloat(1);

                }
            }
            connection.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return price;
    }
    public static float getPrice_modelNumber_oldCar(String vin){
        float price=0;
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select sellingPrice from old_cars where vin ='"+vin+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found with this vin!!");
            }
            else {
                while (resultSet.next()) {
                    price = resultSet.getFloat(1);

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return price;
    }
}
