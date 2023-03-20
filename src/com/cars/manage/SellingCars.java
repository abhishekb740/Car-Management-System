package com.cars.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SellingCars {
    private String modelNumber,brand,date,color,vin;
    private long kmsDriven,mobNo;
    private float buying_price,updated_price;

    public SellingCars(){}

    public SellingCars(String modelNumber, String brand, String date, String color, long kmsDriven, long mobNo, float buying_price,float updated_price,String vin) {
        this.modelNumber = modelNumber;
        this.brand = brand;
        this.date = date;
        this.kmsDriven = kmsDriven;
        this.mobNo = mobNo;
        this.buying_price = buying_price;
        this.color=color;
        this.updated_price=updated_price;
        this.vin=vin;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDate() {
        return date;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(long kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public long getMobNo() {
        return mobNo;
    }

    public void setMobNo(long mobNo) {
        this.mobNo = mobNo;
    }

    public float getBuying_price() {
        return buying_price;
    }

    public void setBuying_price(float buying_price) {
        this.buying_price = buying_price;
    }

    public float getUpdated_price() {
        return updated_price;
    }

    public void setUpdated_price(float updated_price) {
        this.updated_price = updated_price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public boolean addingOldCars()
    {
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into old_cars values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);
            float sellingPrice = this.getUpdated_price()*120/100;
            pstmt.setString(1,this.getModelNumber());
            pstmt.setString(2,this.getBrand());
            pstmt.setString(3,this.getDate());
            pstmt.setLong(4,this.getKmsDriven());
            pstmt.setLong(5,this.getMobNo());
            pstmt.setFloat(6,this.getBuying_price());
            pstmt.setString(7,this.getColor());
            pstmt.setFloat(8,this.getUpdated_price());
            pstmt.setString(9,this.getVin());

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
    public boolean addBuyCarList(int customerId){
        boolean res=false;
        try {
            Connection connection=ConnectionProvider.createConnection();
            String q= "insert into buy_cars_list values(?,?)";
            PreparedStatement pstmt = connection.prepareStatement(q);

            pstmt.setString(1,this.getVin());
            pstmt.setInt(2,customerId);


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
