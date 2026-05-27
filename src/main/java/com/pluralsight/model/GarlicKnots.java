package com.pluralsight.model;

public class GarlicKnots implements OrderItem {

    private static final double price = 1.50;

    public double getPrice() {return price;}

    @Override
    public String getLabel() {return "Garlic Knots"; }

    @Override
    public String toString() {
        return String.format(" Garlic Knots - $%.2f%n", getPrice());
    }
}
