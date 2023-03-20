package com.cars.manage;

import java.sql.*;
public class ConnectionProvider {

    static Connection connection;

    public static Connection createConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String user="root";
            String password="Tushar786@";
            String url="jdbc:mysql://localhost:3306/cars_manage";
            connection=DriverManager.getConnection(url,user,password);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return connection;

    }
}
