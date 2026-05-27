package com.pluralsight;

import com.pluralsight.ui.InputHelper;
import com.pluralsight.ui.PizzaScreen;

public class OrderScreen {

    public static boolean run() {
        Order order = new Order();

        while (true) {
            printOrderMenu(order);
            int choice = InputHelper.readInt("  Choice: ", 0, 4);

            switch (choice) {
                case 1 -> order.addItem(PizzaScreen.buildPizza());
                case 2 -> order.addItem(DrinkScreen.buildDrink());
                case 3 -> {
                    order.addItem(new GarlicKnots());
                    System.out.println(" Garlic Knots added! ($1.50)")
                }
                case 4 -> {
                    if (order.isEmpty()) {
                        System.out.println(" Your order is empty!");
                        break;
                    }
                    boolean confirmed = CheckoutScreen.run(order);
                    return confirmed;
                }               // exit order loop
                case 0 -> {
                    if (InputHelper.readYesNo(" Cancel order and return to home?")) {
                        System.out.println(" Order cancelled.");
                        return false;

                        // Cancel ord

                    }
                }
            }
        }
    }


    private static void printOrderMenu(Order order) {
        if (!order.isEmpty()) {
            System.out.println(" Current items (newest first):");
            for (Object item : order.getItems()) {
                System.out.print(item.toString());
            }
            System.out.printf(" Running total: $%.2f%n", order.getTotal());
        }

        System.out.println("");
        System.out.println("  1) Add Pizza");
        System.out.println("  2) Add Drink");
        System.out.println("  3) Add Garlic Knots   ($1.50)");
        System.out.println("  4) Checkout");
        System.out.println("  0) Cancel Order");
        System.out.println("");
    }
}



