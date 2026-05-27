package com.pluralsight.ui;

import com.pluralsight.OrderScreen;

public class HomeScreen {

    public static void run() {
        while (true) {


            System.out.println("Choose your option");
            System.out.println("1) New Order ");
            System.out.println("0) Exit      ");

            int choice = InputHelper.readInt("  Choice: ", 0, 1);
            if (choice == 0) {
                System.out.println("\n  Thanks for visiting Pizzalicious!\n");
                break;
            }
            OrderScreen.run();
        }


    }

    private static void printBanner(){
        System.out.println("===============================================================");
        System.out.println("                   WELCOME TO PIZZALICIOUS                       ");
        System.out.println("===============================================================");


    }
}
