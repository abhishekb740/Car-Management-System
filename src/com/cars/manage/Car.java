package com.cars.manage;

public class Car {
    private String modelNumber;
    private String brand;
    private String color,vin;
    private float price;

    public Car() {
    }

    public Car(String modelNumber, String brand, String color, float price,String vin) {
        this.modelNumber = modelNumber;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.vin = vin;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelName='" + modelNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
