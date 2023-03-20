package com.cars.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminLogin extends UserLogin{
    public AdminLogin(){
        super();
    }
    @Override
    public boolean authentication(){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            String query="select password from admin where username='"+this.getUserName()+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString(1).equals(this.getPassword())) {
                    res = true;
                }
            }
            if(this.getUserName().equals("admin")&&this.getPassword().equals("admin")){
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
}
