package com.cars.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.io.*;

public class CarAdd {
    public static boolean insertCarToDatabase(Car car){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into cars (modelNumber,brand,color,price,vin) values(?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);

            pstmt.setString(1,car.getModelNumber());
            pstmt.setString(2,car.getBrand());
            pstmt.setString(3,car.getColor());
            pstmt.setFloat(4,car.getPrice());
            pstmt.setString(5,car.getVin());

            pstmt.executeUpdate();
            connection.close();
            res=true;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public static boolean addCarsViaCSV(){
        Scanner in = new Scanner(System.in);
        boolean res = false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            Statement statement=connection.createStatement();
            System.out.println("Enter the .csv file name to be updated");
            String fileName=in.nextLine();
            if(fileName.contains(".csv")){
                fileName=fileName.replace(".csv","");
            }
            String query="load data infile 'C:/Users/Tushar/OneDrive/Desktop/DBMS/csv Files/"+fileName+".csv' into table cars fields terminated by ',' enclosed by '\"' lines terminated by '\\n' ignore 1 rows";
            PreparedStatement p=connection.prepareStatement(query);
            p.execute();
            connection.close();
            res = true;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public static boolean updateCarViaCSV(){
        boolean res=false;
        String line = "";
        String splitBy = ",";
        Scanner in = new Scanner(System.in);
        try
        {
            System.out.println("Enter the .csv file name to be updated");
            String fileName=in.nextLine();
            if(fileName.contains(".csv")){
                fileName=fileName.replace(".csv","");
            }
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Tushar\\OneDrive\\Desktop\\DBMS\\csv Files\\"+fileName+".csv"));
            int flag=0;
            while ((line = br.readLine()) != null)
            {
                if(flag==0){
                    flag=1;
                    continue;
                }
                String[] car = line.split(splitBy);

                Connection connection=ConnectionProvider.createConnection();
                Statement statement=connection.createStatement();
                String query="select vin from cars where vin='"+car[0]+"'";
                ResultSet resultSet = statement.executeQuery(query);
                if(!resultSet.isBeforeFirst())
                {
                    String q= "insert into cars (modelNumber,brand,color,price,vin) values(?,?,?,?,?)";
                    PreparedStatement pstmt = connection.prepareStatement(q);

                    pstmt.setString(1,car[1]);
                    pstmt.setString(2,car[2]);
                    pstmt.setString(3,car[3]);
                    pstmt.setFloat(4,Float.parseFloat(car[4]));
                    pstmt.setString(5,car[0]);

                    pstmt.executeUpdate();
                }
                else {
                    String q= "update cars set modelNumber = '"+car[1]+"',brand = '"+car[2]+"',color = '"+car[3]+"',price="+Float.parseFloat(car[4])+" where vin='"+car[0]+"'" ;
                    PreparedStatement pstmt = connection.prepareStatement(q);
                    pstmt.executeUpdate();
                }
                connection.close();
                res=true;

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
}
