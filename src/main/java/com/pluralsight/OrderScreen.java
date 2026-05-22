package com.pluralsight;

public class OrderScreen {

    public static boolean run() {
        Order order = new Order();

        while (true) {
            printOrderMenu(order);
            int choice = InputHelper.readInt("  Choice: ", 0, 4);

            switch (choice) {
                case 1 -> order.addItem(PizzaScreen.buildPizza()) ;
                case 2 ;
                case 3 ;
                case 4 ;               // exit order loop
                case 0 ;                         // Cancel ord
                        return false;
                    }
                }
            }
        }




    private static void printOrderMenu(Order order) {
        System.out.println("");
        System.out.println("  1) Add Pizza");
        System.out.println("  2) Add Drink");
        System.out.println("  3) Add Garlic Knots   ($4.99)");
        System.out.println("  4) Checkout");
        System.out.println("  0) Cancel Order");
        System.out.println("");
    }




