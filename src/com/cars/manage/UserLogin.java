package com.cars.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin implements LoginInterface {

    private String userName;
    private String password;

    public UserLogin(){}

    public UserLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void input(){
        Scanner in= new Scanner(System.in);
        System.out.println("Enter the username");
        String userName= in.nextLine();
        this.setUserName(userName);
        System.out.println("Enter the password");
        String password=in.nextLine();
        this.setPassword(password);

    }
    @Override
    public boolean authentication(){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="select password from signup where username='"+this.getUserName()+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString(1).equals(this.getPassword())) {
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
    public int getId()
    {
        int res=-1;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="select id from signup where username='"+this.getUserName()+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                res=resultSet.getInt(1);
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
