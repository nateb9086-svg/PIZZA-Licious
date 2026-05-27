package com.pluralsight.service;

import com.pluralsight.model.Order;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptService {

    private static final String receipts = "receipts";

    public static String writeReceipt(Order order) throws IOException {
        File dir = new File(receipts);
        if (!dir.exists()) dir.mkdirs();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String filename = String.format("%s/receipt_order%d_%s.txt", receipts, order.getId(), timestamp);

        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println("");
            pw.println("Your Pizza-Licious RECEIPT");
            pw.println("");
            pw.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")));
            pw.println("");
            pw.print(order.getSummary());
            pw.println("");
            pw.println("Thank you for your order!");
            pw.println("We hope to see you again soon");

        }
        return filename;
    }
}
