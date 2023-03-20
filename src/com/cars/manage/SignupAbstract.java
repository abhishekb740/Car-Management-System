package com.cars.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;

abstract class SignupAbstract {

    private String userName;
    private String password;
    public SignupAbstract(){}
    public SignupAbstract(String userName, String password) {
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

    public void createAccount(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into signup (username,password) values(?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);

            pstmt.setString(1,this.getUserName());
            pstmt.setString(2,this.getPassword());

            pstmt.executeUpdate();
            System.out.println("Account created successfully!!");
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void createAccountAdmin(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into admin (username,password) values(?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);

            pstmt.setString(1,this.getUserName());
            pstmt.setString(2,this.getPassword());

            pstmt.executeUpdate();
            System.out.println("Account created successfully!!");
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public abstract void acceptDetails();
    public abstract void submitDetails();

}
