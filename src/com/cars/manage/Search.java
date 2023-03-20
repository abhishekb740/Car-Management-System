package com.cars.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Search implements SearchInterface{
    @Override
    public void searchCars_brand(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the brand of the car to be searched");
            String brand = in.nextLine();
            ResultSet resultSet = statement.executeQuery("select * from cars where brand like '%"+brand+"%'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found with this brand!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nVehicle Identification NUmber : %s\nModel name : %s\nBrand : %s\nColor : %s\nPrice : %f\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5));
                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void searchCars_price(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the price range");
            float price=in.nextFloat();
            ResultSet resultSet = statement.executeQuery("select * from cars where price <="+price);
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found within this price range!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nVehicle Identification NUmber : %s\nModel name : %s\nBrand : %s\nColor : %s\nPrice : %f\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5));

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void searchCars_modelNumber(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the model Number of the car");
            String modelNumber=in.nextLine();
            ResultSet resultSet = statement.executeQuery("select * from cars where modelNumber ='"+modelNumber+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found with this modelNumber!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nVehicle Identification NUmber : %s\nModel name : %s\nBrand : %s\nColor : %s\nPrice : %f\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5));

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void searchCars_vin(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the vin of the car");
            String vin=in.nextLine();
            ResultSet resultSet = statement.executeQuery("select * from cars where vin ='"+vin+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found with this vin!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nVehicle Identification NUmber : %s\nModel name : %s\nBrand : %s\nColor : %s\nPrice : %f\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getFloat(5));

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void searchOldCars_vin(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the vin of the car");
            String vin=in.nextLine();
            ResultSet resultSet = statement.executeQuery("select * from soldCars_details where vin ='"+vin+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found with this vin!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nModel Number : %s\nBrand : %s\nColor : %s\nPrice : %f\nVehicle Identification NUmber : %s\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(7), resultSet.getFloat(8), resultSet.getString(9));

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void searchOldCars_brand(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the brand of the car to be searched");
            String brand = in.nextLine();
            ResultSet resultSet = statement.executeQuery("select model_number,brand,color,sellingPrice,vin from old_cars where brand like '%"+brand+"%'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found with this brand!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nModel Number : %s\nBrand : %s\nColor : %s\nPrice : %f\nVehicle Identification NUmber : %s\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getFloat(4), resultSet.getString(5));

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void searchOldCars_price(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the price range");
            float price=in.nextFloat();
            ResultSet resultSet = statement.executeQuery("select model_number,brand,color,sellingPrice,vin from old_cars where sellingPrice <="+price);
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found within this price range!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nModel Number : %s\nBrand : %s\nColor : %s\nPrice : %f\nVehicle Identification NUmber : %s\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getFloat(4), resultSet.getString(5));

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void searchOldCars_modelNumber(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the model Number of the car");
            String modelNumber=in.nextLine();
            ResultSet resultSet = statement.executeQuery("select model_number,brand,color,sellingPrice,vin from old_cars where model_number ='"+modelNumber+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found with this modelNumber!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nModel Number : %s\nBrand : %s\nColor : %s\nPrice : %f\nVehicle Identification NUmber : %s\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getFloat(4), resultSet.getString(5));

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void searchCustomer_id(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the id of the customer to be searched");
            int id=in.nextInt();
            ResultSet resultSet = statement.executeQuery("select * from customer_details where Customerid='"+id+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No customer is found with this ID!!");
            }
            else {
                while (resultSet.next()) {
//                System.out.printf("\n\nFirst Name : %s\nLast Name : %s\nAddress : %s\nPhone Number : %d\n",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getLong(4));
                    System.out.printf("\n\nCustomer ID : %d\nFirst Name : %s\nLast Name : %s\nAddress : %s\nPhone Number : %d\nPremium taken : %s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getLong(5), resultSet.getString(6));
                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void searchCustomer_fname(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the First name of the customer to be searched");
            String fname=in.nextLine();
            ResultSet resultSet = statement.executeQuery("select * from customer_details where FirstName like '%"+fname+"%'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No customer is found with this firstName!!");
            }
            else {
                while (resultSet.next()) {
//                System.out.printf("\n\nFirst Name : %s\nLast Name : %s\nAddress : %s\nPhone Number : %d\n",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getLong(4));
                    System.out.printf("\n\nCustomer ID : %d\nFirst Name : %s\nLast Name : %s\nAddress : %s\nPhone Number : %d\nPremium taken : %s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getLong(5), resultSet.getString(6));
                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public void searchCustomer_mobno(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the First name of the customer to be searched");
            long mobno=in.nextLong();
            ResultSet resultSet = statement.executeQuery("select * from customer_details where Phone_Number = '"+mobno+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No customer is found with this mobileNumber!!");
            }
            else {
                while (resultSet.next()) {
//                System.out.printf("\n\nFirst Name : %s\nLast Name : %s\nAddress : %s\nPhone Number : %d\n",resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getLong(4));
                    System.out.printf("\n\nCustomer ID : %d\nFirst Name : %s\nLast Name : %s\nAddress : %s\nPhone Number : %d\nPremium taken : %s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getLong(5), resultSet.getString(6));
                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void searchSoldCars_vin(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the vin of the car");
            String vin=in.nextLine();
            ResultSet resultSet = statement.executeQuery("select * from soldCars_details where vin ='"+vin+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No car is found with this vin!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nModel Number : %s\nBrand : %s\nColor : %s\nPrice : %f\nVehicle Identification NUmber : %s\n", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getFloat(4), resultSet.getString(5));

                }
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void searchSoldCarsList_vin(){
        Scanner in = new Scanner(System.in);
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the vin of the car");
            String vin=in.nextLine();
            ResultSet resultSet = statement.executeQuery("select * from soldCars_details where vin ='"+vin+"'");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No list is found with this vin!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nCustomer Id : %d\nVehicle Identification NUmber : %s\n", resultSet.getInt(1), resultSet.getString(2));
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
