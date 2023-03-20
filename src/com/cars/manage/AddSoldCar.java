package com.cars.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddSoldCar {
    private Car car;
    public AddSoldCar(){}

    public AddSoldCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public boolean addSoldCarToDatabase(){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into soldcars_details values(?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);

            pstmt.setString(1,this.getCar().getModelNumber());
            pstmt.setString(2,this.getCar().getBrand());
            pstmt.setString(3,this.getCar().getColor());
            pstmt.setFloat(4,this.getCar().getPrice());
            pstmt.setString(5,this.getCar().getVin());

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
    public boolean addSoldCarList(int customerId){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into sold_cars_list values(?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);

            pstmt.setInt(1,customerId);
            pstmt.setString(2,this.getCar().getVin());

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

}
