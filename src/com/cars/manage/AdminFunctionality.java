package com.cars.manage;

import java.util.Scanner;

public class AdminFunctionality {
    public static void functionality(){
        Scanner in= new Scanner(System.in);
        String choice;
        while (true)
        {
            System.out.printf("\n<----------------------------------ADMIN FUNCTIONALITY--------------------------------->\n");
            System.out.println("press 1 for adding cars");
            System.out.println("press 2 for deleting cars");
            System.out.println("press 3 for displaying");
            System.out.println("press 4 for searching");
            System.out.println("press 5 for updating");
            System.out.println("press 6 for adding collaborator");
            System.out.println("press 0 for logout");
            System.out.printf("<---------------------------------------------------------------------------------------->\n");
            System.out.println("Enter your choice");

            choice=in.nextLine();
            if(choice.equals("1"))
            {
                System.out.println("Press 1 if you want to add manually\nPress 2 if you want to add and update via csv file");
                String addChoice=in.nextLine();
                if(addChoice.equals("1")){
                    System.out.println("Enter the model name of car");
                    String modelNumber = in.nextLine();
                    System.out.println("Enter the brand of car");
                    String brand = in.nextLine();
                    System.out.println("Enter the color of car");
                    String color = in.nextLine();
                    System.out.println("Enter the price of car");
                    float price = in.nextFloat();
                    in.nextLine();
                    System.out.println("Enter the vehicle identification number of car");
                    String vin = in.nextLine();

                    Car car=new Car(modelNumber,brand,color,price,vin);
                    boolean res = CarAdd.insertCarToDatabase(car);
                    if(res)
                    {
                        System.out.println("\ncar is successfully added in the list");
                    }
                    else {
                        System.out.println("\nsomething went wrong please try again");
                    }
                }
                else if(addChoice.equals("2")){
                    boolean res = CarAdd.addCarsViaCSV();
                    if(res)
                    {
                        System.out.println("\ncars are successfully added via csv in the list");
                    }
                    else {
                        System.out.println("\nsomething went wrong please try again");
                    }
                }
                else {
                    System.out.println("wrong choice please select the correct choice");
                }


            }

            else if (choice.equals("2"))
            {
                System.out.println("Enter the vehicle identification number of the car to be deleted");
                String vin=in.nextLine();
                boolean res= CarDeletion.deleteCar(vin);
                if(res)
                {
                    System.out.println("\ncar is successfully deleted from the list");
                }
                else {
                    System.out.println("\nsomething went wrong please try again");
                }
            }
            else if (choice.equals("3")){
                System.out.printf("\n<----------------------------------DISPLAYING CHOICES--------------------------------->\n");
                System.out.println("press 1 to display new cars");
                System.out.println("press 2 to display old cars");
                System.out.println("press 3 to display customers");
                System.out.println("press 4 to display sold cars details");
                System.out.println("press 5 to display sold cars ownerId list");
                System.out.println("press 6 to display rating and feedback given by users");
                System.out.println("press 7 to display the admin details");
                System.out.println("press 0 or any other to go back");
                System.out.printf("<--------------------------------------------------------------------------------------->\n");
                String display_choice=in.nextLine();
                if(display_choice.equals("1")){
                    CarDisplay.displayCar();
                }
                else if(display_choice.equals("2")){
                    CarDisplay.displayOldCar();
                }
                else if(display_choice.equals("3")){
                    CustomerDisplay.displayCustomer();
                }
                else if(display_choice.equals("4")){
                    SoldCarDisplay.displaySoldCarDetails();
                }
                else if(display_choice.equals("5")){
                    SoldCarDisplay.displaySoldCarsList();
                }
                else if(display_choice.equals("6")){
                    RatingFeedback.displayRating();
                }
                else if(display_choice.equals("7")){
                    AdminCollaborator.displayAdmin();
                }
            }
            else if (choice.equals("4")){
                System.out.printf("\n<----------------------------------SEARCHING CHOICES----------------------------------->\n");
                System.out.println("press 1 to search new cars");
                System.out.println("press 2 to search old cars");
                System.out.println("press 3 to search customers");
                System.out.println("press 4 to search sold cars details");
                System.out.println("press 5 to search sold cars ownerId list");
                System.out.println("press 0 or any other to go back");
                System.out.printf("<---------------------------------------------------------------------------------------->\n");
                String search_choice=in.nextLine();
                if(search_choice.equals("1")){
                    System.out.printf("\n<----------------------------------NEW CAR SEARCHING CHOICES--------------------------------->\n");
                    System.out.println("press 1 to search on brand");
                    System.out.println("press 2 to search on model name");
                    System.out.println("press 3 to search on price range");
                    System.out.println("press 4 to search on Vehicle Identification Number");
                    System.out.println("press 0 to go back");
                    System.out.printf("<-------------------------------------------------------------------------------------------->\n");
                    String carSearchChoice=in.nextLine();
                    Search search = new Search();
                    if(carSearchChoice.equals("1")){
                        search.searchCars_brand();
                    }
                    else if(carSearchChoice.equals("2")){
                        search.searchCars_modelNumber();
                    }
                    else if(carSearchChoice.equals("3")){
                        search.searchCars_price();
                    }
                    else if(carSearchChoice.equals("4")){
                        search.searchCars_vin();
                    }
                }
                else if(search_choice.equals("2")){
                    System.out.printf("\n<----------------------------------OLD CAR SEARCHING CHOICES--------------------------------->\n");
                    System.out.println("press 1 to search on brand");
                    System.out.println("press 2 to search on model name");
                    System.out.println("press 3 to search on price range");
                    System.out.println("press 4 to search on Vehicle Identification Number");
                    System.out.println("press 0 to go back");
                    System.out.printf("<-------------------------------------------------------------------------------------------->\n");
                    String carSearchChoice=in.nextLine();
                    Search search = new Search();
                    if(carSearchChoice.equals("1")){
                        search.searchOldCars_brand();
                    }
                    else if(carSearchChoice.equals("2")){
                        search.searchOldCars_modelNumber();
                    }
                    else if(carSearchChoice.equals("3")){
                        search.searchOldCars_price();
                    }
                    else if(carSearchChoice.equals("4")){
                        search.searchOldCars_vin();
                    }
                }
                else if(search_choice.equals("3")){
                    System.out.printf("\n<----------------------------------CUSTOMER SEARCHING CHOICES--------------------------------->\n");
                    System.out.println("press 1 to search on id");
                    System.out.println("press 2 to search on first name");
                    System.out.println("press 3 to search on mobile number");
                    System.out.println("press 0 or any other to go back");
                    System.out.printf("<----------------------------------------------------------------------------------------------->\n");
                    String carSearchChoice=in.nextLine();
                    Search search = new Search();
                    if(carSearchChoice.equals("1")){
                        search.searchCustomer_id();
                    }
                    else if(carSearchChoice.equals("2")){
                        search.searchCustomer_fname();
                    }
                    else if(carSearchChoice.equals("3")){
                        search.searchCustomer_mobno();
                    }
                }
                else if(search_choice.equals("4")){
                    Search search = new Search();
                    search.searchSoldCars_vin();
                }
                else if(search_choice.equals("5")){
                    Search search = new Search();
                    search.searchSoldCarsList_vin();
                }
            }
            else if(choice.equals("5")){
                System.out.println("<---------------------------------------UPDATE CHOICES---------------------------------->");
                System.out.println("Press 1 if you want to update your password");
                System.out.println("Press 2 if you want to update the cars List via csv");
                System.out.println("press 0 or any other to go back");
                System.out.println("<--------------------------------------------------------------------------------------->");
                String updateChoice = in.nextLine();
                if(updateChoice.equals("1")){
                    boolean res = Update.updateAdminPassword();
                    if(res)
                    {
                        System.out.println("\nPassword updated successfully");
                    }
                    else {
                        System.out.println("\nsomething went wrong please try again");
                    }
                }
                else if(updateChoice.equals("2")){
                    boolean res = CarAdd.updateCarViaCSV();
                    if(res)
                    {
                        System.out.println("\ncars are successfully updated via csv in the list");
                    }
                    else {
                        System.out.println("\nsomething went wrong please try again");
                    }
                }
            }
            else if (choice.equals("6")) {
                while (true)
                {
                    System.out.println("enter the username");
                    String username=in.nextLine();
                    boolean res=CheckAlreadyExist.adminUsernameExists(username);
                    if(res){
                        System.out.println("This username is already taken!! ,try some other username");
                    }
                    else {
                        System.out.println("Enter the password");
                        String password=in.nextLine();
                        AdminCollaborator addAdmin = new AdminCollaborator();
                        addAdmin.setUserName(username);
                        addAdmin.setPassword(password);
                        addAdmin.createAccountAdmin();
                        addAdmin.acceptDetails();
                        addAdmin.submitDetails();
                        break;
                    }
                }

            }
            else if (choice.equals("0")) {
                break;
            }
            else {
                System.out.println("invalid input choice");
            }
        }
    }
}
