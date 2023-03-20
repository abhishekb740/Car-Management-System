package com.cars.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Premium {
    public static void takePremium(int login_id){
        try {
            Connection connection=ConnectionProvider.createConnection();
            String query="update customer_details set Premium='YES' where Customerid="+login_id;
            PreparedStatement p=connection.prepareStatement(query);
            p.execute();
            System.out.println("Premium taken successfully!!");
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static boolean checkPremium(int login_id){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="select Premium from customer_details where Customerid='"+login_id+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString(1).equals("YES")) {
                    res = true;
                }
            }
            connection.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

}
