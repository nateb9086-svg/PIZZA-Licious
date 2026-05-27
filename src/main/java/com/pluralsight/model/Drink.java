package com.pluralsight.model;

import java.util.List;

public class Drink implements OrderItem{
    public enum Size {small, medium, large }
    private Size size;
    private String flavor;

    public static final List<String> flavorOptions = List.of( "Coca-Cola", "Diet Coke", "Sprite", "Orange Fanta",
            "Root Beer", "Lemonade", "Iced Tea", "Water");
    private static final double[] prices = {2.00, 2.50, 3.00};

    public Drink(Size size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }
    public double getPrices() {
        return prices[size.ordinal()];
    }

    @Override
    public String getLabel() {
        return String.format("Drink (%s %s)",
                size.name().charAt(0) + size.name().substring(1).toLowerCase(),
                flavor);
    }

    @Override
    public String toString() {
        return String.format(" Drink (%s %s) - $%.2f%n", size.name().charAt(0)
                + size.name().substring(1).toLowerCase(), flavor, getPrice());
    }

}
