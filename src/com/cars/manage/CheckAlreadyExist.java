package com.cars.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckAlreadyExist {
    public static boolean exists(String userName)
    {
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="select username from signup where username='"+userName+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString(1).equals(userName)) {
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
    public static boolean adminUsernameExists(String userName)
    {
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="select username from admin where username='"+userName+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString(1).equals(userName)) {
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
