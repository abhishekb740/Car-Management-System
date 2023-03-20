package com.cars.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RatingFeedback {
    public static void takingRating(int customerId){
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("please rate us out of 5 that is either 1,2,3,4 or 5");
            int rating = in.nextInt();
            in.nextLine();
            System.out.println("Please give your feedback and suggestions to improve");
            String feedback=in.nextLine();
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into rating values(?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);

            pstmt.setInt(1,customerId);
            pstmt.setInt(2,rating);
            pstmt.setString(3,feedback);

            pstmt.executeUpdate();
            System.out.println("Thank you for rating us and giving us a feedback!!");
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static float avgRating(){
        float rating=0;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select avg(rating) from rating");

            while (resultSet.next()) {
                rating = resultSet.getFloat(1);
            }
            connection.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rating;
    }
    public static boolean checkRating(int login_id){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="select rating from rating where Customer_id='"+login_id+"'";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.isBeforeFirst()){
                res=true;
            }
            connection.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public static void displayRating(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from rating");
            if(!resultSet.isBeforeFirst()){
                System.out.println("We haven't been rated yet!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nCustomer ID : %d\nRating : %d\nFeedback : %s\n", resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3));
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
