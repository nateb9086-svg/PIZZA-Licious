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
    private boolean stuffedCrust;

    private static final Map<Size, Double> basePrice = Map.of(
            Size.personal, 8.50, Size.medium, 12.00, Size.large, 16.50);
    private static final Map<Size, Double> meatPrice = Map.of(
            Size.personal, 1.00, Size.medium, 2.00, Size.large, 3.00);
    private static final Map<Size, Double> meatExtra = Map.of(
            Size.personal, 0.50, Size.medium, 1.00, Size.large, 1.50);
    private static final Map<Size, Double> cheesePrice = Map.of(
            Size.personal, .75, Size.medium, 1.50, Size.large, 2.25);
    private static final Map<Size, Double> cheeseExtra = Map.of(
            Size.personal, 0.30, Size.medium, 0.60, Size.large, 0.90
    );


    public static final List<String> meatOptions = List.of(
            "pepperoni", "sausage", "ham", "bacon", "chicken", "meatball");
    public static final List<String> cheeseOptions = List.of(
            "Mozzarella", "Parmesan", "Ricotta", "Goat Cheese", "Buffalo");
    public static final List<String> toppingOptions = List.of(
            "onions", "mushrooms", "bell peppers", "olives", "tomatoes", "spinach",
            "olives", "tomatoes", "spinach", "basil", "pineapple", "anchovies");
    public static final List<String> sauceOptions = List.of(
            "marinara", "alfredo", "pesto", "bbq", "buffalo", "olive oil");


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isStuffedCrust() {
        return stuffedCrust;
    }

    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }

    public void addMeat(String m) { meats.merge(m, 1, Integer::sum);}
    public void addCheese(String c) {cheeses.merge(c, 1, Integer::sum); }
    public void addTopping(String t) {toppings.add(t);}
    public void addSauce(String s) {sauces.add(s);}

    public double getPrice() {
        double price = basePrice.get(size);
        price += calcToppingPrice(meats, meatPrice.get(size), meatExtra.get(size));
        price += calcToppingPrice(cheeses, cheesePrice.get(size), cheeseExtra.get(size));
        return price;
    }


    private double calcToppingPrice(Map<String, Integer> map, double firstPrice1, double extraPrice){

        if (map.isEmpty()) return 0;
        int totalCount = map.values().stream().mapToInt(Integer::intValue).sum();
        return firstPrice1 + totalCount * extraPrice;
    }

    @Override
    public String getLabel() {
        return String.format("Pizza (%s, %s)%s", fmtEnum(type),fmtEnum(size), stuffedCrust ? " [Stuffed Crust]" : "");
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("  Pizza (%s, %s)%s%n",
        fmtEnum(type), fmtEnum(size), stuffedCrust ? " [Stuffed Crust]" : ""));
        appendMappedToppings(sb, "Meats", meats);
        appendMappedToppings(sb, "cheeses", cheeses);
        appendSetToppings(sb, "Regular Toppings", toppings);
        appendSetToppings(sb, "Sauces", sauces);
        sb.append(String.format("  Subtotal: $%.2f%n", getPrice()));
        return sb.toString();
    }

    private void appendMappedToppings(StringBuilder sb, String label, Map<String, Integer> map){

        if (!map.isEmpty()) {
            sb.append("    ").append(label).append(":  ");
            List<String> parts = new ArrayList<>();
            map.forEach((k,v) -> parts.add(v > 1 ? k + " x" + v : k));
            sb.append(String.join(", ", parts)).append("\n");
        }
    }

    private void appendSetToppings(StringBuilder sb, String label, Set<String> set){
        if (!set.isEmpty()){
            sb.append("   ").append(label).append(":  ")
                    .append(String.join(", ", set)).append("\n");
        }
    }

    private String fmtEnum(Enum<?> e) {
        return e.name().replace('_', ' ');
    }
}