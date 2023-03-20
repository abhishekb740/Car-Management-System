package com.cars.manage;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
    public static boolean updateAdminPassword(){
        Scanner in = new Scanner(System.in);
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter your userName");
            String userName = in.nextLine();
            boolean resExist = CheckAlreadyExist.adminUsernameExists(userName);
            if(resExist){
                System.out.println("Enter the new password");
                String password = in.nextLine();
                String query="update admin set password = '"+password+"' where username = '"+userName+"'";
                statement.executeUpdate(query);
                res=true;
            }
            else {
                System.out.println("Sorry No admin exist with this username");
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public static boolean updateUserPassword(){
        Scanner in = new Scanner(System.in);
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter your userName");
            String userName = in.nextLine();
            boolean resExist = CheckAlreadyExist.exists(userName);
            if(resExist){
                System.out.println("Enter the new password");
                String password = in.nextLine();
                String query="update signup set password = '"+password+"' where username = '"+userName+"'";
                statement.executeUpdate(query);
                res=true;
            }
            else {
                System.out.println("Sorry No user exist with this username");
            }
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public static boolean updateUserFirstName(int loginId){
        Scanner in = new Scanner(System.in);
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter your new FirstName");
            String firstName = in.nextLine();
            String query="update customer_details set FirstName = '"+firstName+"' where customerid = "+loginId;
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
    public static boolean updateUserLastName(int loginId){
        Scanner in = new Scanner(System.in);
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter your new LastName");
            String lastName = in.nextLine();
            String query="update customer_details set LastName = '"+lastName+"' where customerid = "+loginId;
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
    public static boolean updateUserAddress(int loginId){
        Scanner in = new Scanner(System.in);
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter your new Address");
            String address = in.nextLine();
            String query="update customer_details set address = '"+address+"' where customerid = "+loginId;
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
    public static boolean updateUserPhoneNumber(int loginId){
        Scanner in = new Scanner(System.in);
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter your new PhoneNumber");
            long phoneNumber=in.nextLong();
            String query="update customer_details set Phone_Number = "+phoneNumber+" where customerid = "+loginId;
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
