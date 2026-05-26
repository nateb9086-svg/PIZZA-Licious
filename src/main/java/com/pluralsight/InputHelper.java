package com.pluralsight;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static int readInt(String prompt, int min, int max) {
        while (true) {
            String raw = readLine(prompt);
            try {
                int v = Integer.parseInt(raw);
                if (v >= min && v <= max) return v;
                System.out.println(" Please enter a number between " + min + " and " + max + ".");
            }
            catch (NumberFormatException e) {
                System.out.println(" Invalid input - please enter a whole number.");
            }
        }

    }

    public static boolean readYesNo(String prompt){
       while (true) {
           String raw = readLine(prompt + " (y/n): ").toLowerCase();
           if (raw.equals("y")) return true;
           if (raw.equals("n")) return false;
           System.out.println(" Please enter y or n.");
       }

    }

    public static int selectFromList(String header, java.util.List<String> options, boolean allowDone){
        System.out.println( "  " + header);
        for (int i = 0; i < options.size(); i++){
            System.out.printf (" %d) %s%n", i + 1, options.get(i));
        }
        if (allowDone) System.out.println("   0) Done");
        int max = options.size();
        int min = allowDone ? 0 : 1;
        return readInt (" Choice: ", min, max) - 1;
    }





}
