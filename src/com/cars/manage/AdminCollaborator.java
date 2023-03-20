package com.cars.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AdminCollaborator extends SignupAbstract {
    private String name,address,email;
    private long phoneNumber;

    public AdminCollaborator(){}
    public AdminCollaborator(String username,String password){
        super(username,password);
    }
    public AdminCollaborator(String username,String password,String email,long phoneNumber){
        super(username,password);
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void acceptDetails() {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the Full Name");
        String username=in.nextLine();
        System.out.println("Enter the Address");
        String address=in.nextLine();
        System.out.println("Enter the email-id");
        String emailId=in.nextLine();
        System.out.println("Enter the phone number");
        long phoneNumber=in.nextLong();
        this.setEmail(emailId);
        this.setPhoneNumber(phoneNumber);
        this.setName(username);
        this.setAddress(address);
    }
    @Override
    public void submitDetails(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into admin_details values(?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);

            pstmt.setString(1,this.getName());
            pstmt.setString(2,this.getAddress());
            pstmt.setString(3,this.getEmail());
            pstmt.setLong(4,this.getPhoneNumber());

            pstmt.executeUpdate();
            System.out.println("Information added successfully!!");
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void displayAdmin(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from admin_details");
            if(!resultSet.isBeforeFirst()){
                System.out.println("No admin detail is available now!!");
            }
            else {
                while (resultSet.next()) {
                    System.out.printf("\n\nName : %s\nAddress : %s\nEmail-Id : %s\nPhone Number : %d\n",  resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4));

                }
                connection.close();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void getContact(){
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select email,phoneNumber from admin_details");
            if(resultSet.isBeforeFirst()){
                System.out.println("<-----------------------------------CONTACT US-------------------------------->\n");
                System.out.println("Email\t\t\tMobileNUmber");
                System.out.println("------------------------------------------------------------------------------");
                while (resultSet.next()) {
                    System.out.printf("%s\t\t\t%d\n",  resultSet.getString(1), resultSet.getLong(2));
                    System.out.println("------------------------------------------------------------------------------");

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
