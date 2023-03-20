package com.cars.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerDisplay {
    public static void displayCustomer(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer_details");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No customer detail is available now!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nCustomer ID : %d\nFirst Name : %s\nLast Name : %s\nAddress : %s\nPhone Number : %d\nPremium taken : %s\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getLong(5), resultSet.getString(6));

                }
                connection.close();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void displayCustomerProfile(int loginId){
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer_details where Customerid="+loginId);
            if(!resultSet.isBeforeFirst()){
                System.out.println("No customer detail is available now!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nFirst Name : %s\nLast Name : %s\nAddress : %s\nPhone Number : %d\n", resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getLong(5));

                }
                connection.close();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
