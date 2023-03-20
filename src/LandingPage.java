import com.cars.manage.*;

import java.util.*;

public class LandingPage {
    public static void main(String[] args) {
        String choice;
        Scanner in = new Scanner(System.in);
        boolean login_flag=false;
        boolean hasTakenPremium=false;
        int login_id=0;
        System.out.println("Press 1 to create the database and its respective tables else any other key to continue.......");
        String database_choice=in.nextLine();
        if(database_choice.equals("1")){
            CreateDatabase.createDatabase();
        }
        while (true)
        {
            System.out.printf("\n<----------------------------------------CHOICES--------------------------------------->\n");
            if (!login_flag)
                System.out.println("press 1 for login/signup");
            else
                System.out.println("press 1 for logout");
            System.out.println("press 2 for searching cars");
            System.out.println("press 3 for taking premium");
            System.out.println("press 4 for buying cars");
            System.out.println("press 5 for selling cars");
            System.out.println("press 6 for viewing and updating your profile");
            System.out.println("press 7 for knowing about us and offers");
            System.out.println("press 8 for rating us and giving a feedback");
            System.out.println("press 0 for exit");
            System.out.printf("<-------------------------------------------------------------------------------------->\n");
            System.out.println("Enter your choice");
            choice=in.nextLine();
            if (choice.equals("1")&&login_flag){
                login_flag=false;
                hasTakenPremium=false;
                System.out.println("Logged out successfully!!");
            }
            else if(choice.equals("1")){
                System.out.println("press a for admin and u for user");
                char ch=in.next().charAt(0);
                if(ch=='u'){
                    System.out.println("press l for login and s for signup");
                    char logChoice=in.next().charAt(0);
                    in.nextLine();
                    if(logChoice=='l')
                    {
                        UserLogin login = new UserLogin();
                        login.input();
                        boolean res=login.authentication();
                        if(res){
                            System.out.println("Logged In successfully!!");
                            login_flag=true;
                            login_id=login.getId();
                            hasTakenPremium=Premium.checkPremium(login_id);
                        }
                        else {
                            System.out.println("Sorry wrong username or password, Please try once again");
                        }
                    }
                    else if (logChoice=='s')
                    {
                        String username;
                        Customer customerDetails = new Customer();
                        while (true)
                        {
                            System.out.println("enter the username");
                            username=in.nextLine();
                            boolean res=CheckAlreadyExist.exists(username);
                            if(res){
                                System.out.println("This username is already taken!! ,try some other username");
                            }
                            else {
                                customerDetails.setUserName(username);
                                break;
                            }
                        }

                        System.out.println("enter the password");
                        String password=in.nextLine();
                        customerDetails.setPassword(password);
                        customerDetails.createAccount();
                        customerDetails.acceptDetails();
                        customerDetails.submitDetails();
                    }
                    else {
                        System.out.println("invalid choice!!Please select the correct option");
                    }

                }
                else if (ch=='a'){
                    in.nextLine();
                    UserLogin adminLogin= new AdminLogin();
                    adminLogin.input();
                    boolean res= adminLogin.authentication();
                    if(res) {
                        System.out.println("Logged In successfully!!");
                        AdminFunctionality.functionality();
                    }
                    else {
                        System.out.println("Sorry, wrong username or password!!");
                    }

                }
                else {
                    System.out.println("invalid choice!!Please select the correct option");
                }
            }
            else if (choice.equals("2")) {
                if(login_flag){
                    System.out.printf("\n<----------------------------------CAR SEARCHING CHOICES--------------------------------->\n");
                    System.out.println("press 1 to search on brand");
                    System.out.println("press 2 to search on model number");
                    System.out.println("press 3 to search on price range");
                    System.out.println("press 0 to go back");
                    System.out.printf("<------------------------------------------------------------------------------------------>\n");
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

                }
                else {
                    System.out.println("please login first!!");
                }
            }
            else if (choice.equals("3")) {
                if(hasTakenPremium){
                    System.out.println("you have already taken premium");
                }
                else if(login_flag){
                    System.out.println("You will have to pay an amount of rs 10000 for taking premium");
                    System.out.println("Do you want to pay it? Press y for yes and n for no");
                    char ch=in.next().charAt(0);
                    in.nextLine();
                    if(ch=='y'){
                        Premium.takePremium(login_id);
                        hasTakenPremium=true;
                    }
                    else if (ch=='n') System.out.println("you are missing many benefits of our application, we suggest you to  take the premium");
                    else {
                        System.out.println("invalid choice!!Please select the correct option");
                    }

                }
                else {
                    System.out.println("please login first!!");
                }

            }
            else if (choice.equals("4")) {
                if(login_flag){
                    Search search = new Search();
                    BuyingCar buyCar = new BuyingCar(search,login_id);
                    System.out.println("Press 1 if you want to buy a new car\nPress 2 if you want to buy an old car");
                    String buy_choice=in.nextLine();
                    if (buy_choice.equals("1")){
                        buyCar.buyNewCar(hasTakenPremium);
                    }
                    else if (buy_choice.equals("2")){
                        buyCar.buyOldCar(hasTakenPremium);
                    }
                    else System.out.println("Oops!! you opted some wrong option");
                }
                else {
                    System.out.println("please login first!!");
                }
            }
            else if (choice.equals("5")) {
                if(login_flag){
                    if (hasTakenPremium){
//                        in.nextLine();
                        System.out.println("Enter the VIN of the car to be sold");
                        String vin=in.nextLine();
                        System.out.println("Enter the model number of the car to be sold");
                        String modelNumber=in.nextLine();
                        System.out.println("Enter the brand of the car to be sold");
                        String brand=in.nextLine();
                        System.out.println("Enter the color of the car to be sold");
                        String color=in.nextLine();
                        System.out.println("Enter the buying date of the car to be sold in the format of yyyy-mm-dd");
                        String date=in.nextLine();
                        System.out.println("Enter the kms driven of the car to be sold");
                        long kmsDriven=in.nextLong();
                        System.out.println("Enter the price at which the car was bought");
                        float buying_price=in.nextFloat();
                        System.out.println("Enter your mobile number");
                        long mobNo=in.nextLong();

                        System.out.println("we will reduce the price of the car per thousand kms driven by 1% from the original buying price\n");
                        long percentReduced=kmsDriven%1000!=0?kmsDriven/1000+1:kmsDriven/1000;
                        if(percentReduced>60){
                            percentReduced=60;
                        }
                        float selling_price=buying_price-(buying_price*(percentReduced)/100);
                        System.out.println("your car price is estimated as rs "+selling_price+" by reducing its price by "+percentReduced+"%\n");
                        System.out.println("Do you want to sell it? Press y for yes and n for no\n");
                        char sellingChoice=in.next().charAt(0);
                        in.nextLine();
                        if(sellingChoice=='y'){
                            SellingCars sellingCars=new SellingCars(modelNumber,brand,date,color,kmsDriven,mobNo,buying_price,selling_price,vin);
                            boolean res1 = sellingCars.addingOldCars();
                            boolean res2 = sellingCars.addBuyCarList(login_id);
                            if(res1 && res2){
                                System.out.println("Your car is sold successfully");
                            }
                            else {
                                System.out.println("something went wrong");
                            }
                        }
                        else if(sellingChoice=='n'){
                            System.out.println("Sorry for the inconvenience");
                        }

                    }
                    else System.out.println("sorry you have to take the premium first to sell your cars");
                }
                else {
                    System.out.println("please login first!!");
                }
            }
            else if (choice.equals("6")){
                if(login_flag){
                    CustomerDisplay.displayCustomerProfile(login_id);
                    System.out.println("\nDo you want to update anything in your profile?? press y for yes and n for no");
                    String update_choice = in.nextLine();
                    if(update_choice.equals("y")) {
                        System.out.printf("\n<----------------------------------USER PROFILE UPDATE CHOICES--------------------------------->\n");
                        System.out.println("press 1 to update your password");
                        System.out.println("press 2 to update your First Name");
                        System.out.println("press 3 to update your Last Name");
                        System.out.println("press 4 to update your Address");
                        System.out.println("press 5 to update your Phone Number");
                        System.out.println("press 0 to go back");
                        System.out.printf("<------------------------------------------------------------------------------------------------>\n");

                        String typeUpdate = in.nextLine();
                        if (typeUpdate.equals("1")) {
                            boolean res = Update.updateUserPassword();
                            if (res) {
                                System.out.println("\nPassword updated successfully");
                            } else {
                                System.out.println("\nsomething went wrong please try again");
                            }
                        } else if (typeUpdate.equals("2")) {
                            boolean res = Update.updateUserFirstName(login_id);
                            if (res) {
                                System.out.println("\nFirst Name updated successfully");
                            } else {
                                System.out.println("\nsomething went wrong please try again");
                            }
                        } else if (typeUpdate.equals("3")) {
                            boolean res = Update.updateUserLastName(login_id);
                            if (res) {
                                System.out.println("\nLast Name updated successfully");
                            } else {
                                System.out.println("\nsomething went wrong please try again");
                            }

                        } else if (typeUpdate.equals("4")) {
                            boolean res = Update.updateUserAddress(login_id);
                            if (res) {
                                System.out.println("\nAddress updated successfully");
                            } else {
                                System.out.println("\nsomething went wrong please try again");
                            }

                        } else if (typeUpdate.equals("5")) {
                            boolean res = Update.updateUserPhoneNumber(login_id);
                            if (res) {
                                System.out.println("\nPhone Number updated successfully");
                            } else {
                                System.out.println("\nsomething went wrong please try again");
                            }

                        }
                    }
                }
                else {
                    System.out.println("Please login first to view your profile");
                }
            }
            else if (choice.equals("7")) {
                System.out.println("<-----------------------------------------ABOUT US---------------------------------------------------->");
                System.out.println("This is an Online car management system application");
                System.out.println("We provide here the facility to buy and sell cars by searching and looking through different cars");
                System.out.println("You can buy new car as well as old cars on best deals");
                float avgRating = RatingFeedback.avgRating();
                if(avgRating>=2.5){
                    System.out.println("We are going great with an average rating of "+avgRating+" out of 5.");
                }
                System.out.println("<----------------------------------------------------------------------------------------------------->\n\n");
                ArrayList<String> offerList = new ArrayList<String>();
                offerList.add("If you will buy the car now, then you can get the free service for the 1st 1000 kms of drive");
                offerList.add("If you will buy the car now, then you can get the insurance of the car(1 year) for free");
                offerList.add("If you will take our premium then you can sell your car from our app on best deals");
                offerList.add("If you will buy the car now, then you can get the accessories like Floor mats and seat cover, jack and tool kit for free");
                offerList.add("If you will buy the car now, then if you want to customize your car then you can customize it by just paying half of the required price");
                offerList.add("If you will buy the car now, then you can get the warranty of the car parts for 1 year");
                Collections.shuffle(offerList);
                System.out.println("<----------------------------------------OFFERS PAGE------------------------------------------------------------------------------>");
                for(int i=0;i<3;i++){
                    System.out.println(offerList.get(i));
                }
                System.out.println("<--------------------------------------------------------------------------------------------------------------------------------->");
                AdminCollaborator.getContact();
            }
            else if(choice.equals("8")){
                if(login_flag){
                    boolean res = RatingFeedback.checkRating(login_id);
                    if(res){
                        System.out.println("You have already rated us!!");
                    }
                    else {
                        RatingFeedback.takingRating(login_id);
                    }
                }
                else {
                    System.out.println("Please login first to rate");
                }
            }
            else if (choice.equals("0")) {
                System.out.println("Thank You for using our app!!");
                break;
            }
            else {
                System.out.println("invalid choice!!Please select the correct option");
            }

        }
    }
}
