package com.cars.manage;

import java.util.Scanner;

public class BuyingCar implements BuyInterface {
    private Search search;
    private int customer_id;
    public BuyingCar(){}
    public BuyingCar(Search search,int customer_id){
        this.search=search;
        this.customer_id=customer_id;
    }
    public void buyNewCar(boolean hasTakenPremium){
        Scanner in = new Scanner(System.in);
        System.out.printf("\n<----------------------------------NEW CAR SEARCHING CHOICES--------------------------------->\n");
        System.out.println("press 1 to search on brand");
        System.out.println("press 2 to search on model name");
        System.out.println("press 3 to search on price range");
        System.out.println("press 4 to see all the available cars");
        System.out.println("press 0 or any other key to go back");
        System.out.printf("<------------------------------------------------------------------------------------------>\n");
        String carSearchChoice=in.nextLine();
//        Search search = new Search();
        if(carSearchChoice.equals("1")){
            this.search.searchCars_brand();
        }
        else if(carSearchChoice.equals("2")){
            this.search.searchCars_modelNumber();
        }
        else if(carSearchChoice.equals("3")){
            this.search.searchCars_price();
        }
        else if(carSearchChoice.equals("4")){
            CarDisplay.displayCar();
        }
        System.out.println("Do you like any of our cars? Press y for yes and n for no");
        char ch=in.next().charAt(0);
        in.nextLine();
        if(ch=='y'){
            System.out.println("Enter the vehicle identification number of the car you liked");
            String vin=in.nextLine();
            String message;
            float updated_price;
            float price=GetCarDetails.getPrice_vin(vin);
            if(hasTakenPremium){
                message="since you are our premium member so you will get a discount of 2%, and you have to pay a total of rs ";
                updated_price=price-price*2/100;
            }
            else {
                message="you have to pay a total of rs ";
                updated_price=price;
            }
            System.out.println(message+updated_price);
            System.out.println("Do you want to pay? Press y for yes and any other for no");
            String payChoice=in.nextLine();
            if(payChoice.equals("y")){
                Car car = GetCarDetails.getCar_vin(vin);
                AddSoldCar addSoldCar = new AddSoldCar(car);
                boolean res = addSoldCar.addSoldCarToDatabase();
                boolean res2 = CarDeletion.deleteCar(vin);
                boolean res3 = addSoldCar.addSoldCarList(customer_id);
                if(res && res2 && res3) System.out.println("Car bought successfully");
                else System.out.println("something went wrong!!");
            }
            else {
                System.out.println("Sorry for the inconvenience");
            }
        }
        else if(ch=='n') System.out.println("sorry for the inconvenience");
    }
    public void buyOldCar(boolean hasTakenPremium){
        Scanner in = new Scanner(System.in);
        System.out.printf("\n<----------------------------------OLD CAR SEARCHING CHOICES--------------------------------->\n");
        System.out.println("press 1 to search on brand");
        System.out.println("press 2 to search on model name");
        System.out.println("press 3 to search on price range");
        System.out.println("press 4 to see all the available cars");
        System.out.println("press 0 or any other to go back");
        System.out.printf("<-------------------------------------------------------------------------------------------->\n");
        String carSearchChoice=in.nextLine();
        if(carSearchChoice.equals("1")){
            this.search.searchOldCars_brand();
        }
        else if(carSearchChoice.equals("2")){
            this.search.searchOldCars_modelNumber();
        }
        else if(carSearchChoice.equals("3")){
            this.search.searchOldCars_price();
        }
        else if(carSearchChoice.equals("4")){
            CarDisplay.displayOldCar();
        }
        System.out.println("Do you like any of our cars? Press y for yes and n for no");
        char ch=in.next().charAt(0);
        in.nextLine();
        if(ch=='y'){
            System.out.println("Enter the vehicle identification number of the car you liked");
            String vin=in.nextLine();
            String message;
            float updated_price;
            float price=GetCarDetails.getPrice_modelNumber_oldCar(vin);
            if(hasTakenPremium){
                message="since you are our premium member so you will get a discount of 2%, and you have to pay a total of rs ";
                updated_price=price-price*2/100;
            }
            else {
                message="you have to pay a total of rs ";
                updated_price=price;
            }
            System.out.println(message+updated_price);
            System.out.println("Do you want to pay? Press y for yes and any other for no");
            String payChoice=in.nextLine();
            if(payChoice.equals("y")){
                Car car = GetCarDetails.getOldCar_vin(vin);
                AddSoldCar addSoldCar = new AddSoldCar(car);
                boolean res = addSoldCar.addSoldCarToDatabase();
                boolean res2 = CarDeletion.deleteOldCar(vin);
                boolean res3 = addSoldCar.addSoldCarList(customer_id);
                if(res && res2 && res3) System.out.println("Car bought successfully");
                else System.out.println("something went wrong!!");
            }
            else {
                System.out.println("Sorry for the inconvenience");
            }
        }
        else if(ch=='n') System.out.println("sorry for the inconvenience");
    }
}
