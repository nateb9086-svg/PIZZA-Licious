package com.pluralsight;

public class HomeScreen {
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("                   WELCOME TO PIZZALICIOUS                       ");
        System.out.println("===============================================================");

        System.out.println("Choose your option");
        System.out.println("1) New Order ");
        System.out.println("0) Exit      ");

        int choice = InputHelper.readInt("  Choice: ", 0, 1);
        if (choice == 0) {
            System.out.println("  Thanks for visiting Pizzalicious!");
            break;
        }
        OrderScreen.run();






    }


}
