package com.pluralsight.model;

import java.util.*;

public class Pizza implements OrderItem {
    public enum Type {thinCrust, regularCrust, thickCrust, cauliflowerCrust}
    public enum Size {personal, medium, large}

    private Type type;
    private Size size;
    private Map<String, Integer> meats = new LinkedHashMap<>();
    private Map<String, Integer> cheeses = new LinkedHashMap<>();
    private Map<String, Integer> toppings = new LinkedHashMap<>();
    private Map<String, Integer> sauces = new LinkedHashMap<>();

    private static final Map<Size, Double> basePrice = Map.of(

            Size.personal, 8.50, Size.medium, 12.00, Size.large, 16.50


    );
    private static final double toppingPrice = 0.75;

    public static final List<String> meatOptions = List.of("pepperoni", "suasage", "ham", "bacon", "chicken", "meatball");
}
