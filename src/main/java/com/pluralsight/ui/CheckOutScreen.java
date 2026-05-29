package com.pluralsight.ui;

import com.pluralsight.model.Order;
import com.pluralsight.service.ReceiptService;

import java.io.IOException;

public class CheckOutScreen {

    public CheckOutScreen() {
    }

    public static boolean run(Order order){
        System.out.println("");
        System.out.println(" CHECKOUT ");
        System.out.println("");
        System.out.print(order.getSummary());

        double subtotal = order.getTotal();
       // double tax = subtotal * 0.08;
        //        double grandTotal = subtotal + tax;
       // System.out.printf("  Tax (8%%): $%.2f%n", tax);
       // System.out.printf(" GRAND TOTAL: $%.2f%n%n", grandTotal);



        System.out.println(" 1) Confirm Order");
        System.out.println(" 2) Cancel Order");

        int choice = InputHelper.readInt("Choice: ",1,2);

        if (choice == 1) {
            try {
                String path = ReceiptService.writeReceipt(order);

                System.out.println("\n Order Confirmed!");
                System.out.println(" Receipt Saved to: " + path);
            }
            catch (IOException e){
                System.out.println("  Could not write receipt: " + e.getMessage());
            }
            return true;
        }
        else {
            System.out.println(" Order Cancelled.");
            return false;
        }

    }
}
