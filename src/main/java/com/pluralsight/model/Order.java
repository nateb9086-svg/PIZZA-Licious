package com.pluralsight.model;

import java.util.*;

public class Order {
    private static int nextId = 1;

    private final int id;
    private final List<Object> items = new ArrayList<>();

    public Order() {
        this.id = nextId++;
    }

    public int getId() {return id; }

    public void addItem(Object item) {
        items.add(0,item);
    }
    public List<Object> getItems(){
        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() { return items.isEmpty(); }

    public double getTotal() {
        double total = 0;
        for (Object item : items) {
            if (item instanceof Pizza p) total += p.getPrice();
            else if (item instanceof Drink d) total += d.getPrice();
            else if (item instanceof GarlicKnots gk) total += gk.getPrice();
        }
        return total;
    }
    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(""));
        sb.append(String.format("ORDER #%d%n", id));
        sb.append(String.format(""));
        if (items.isEmpty()){
            sb.append(" (no items)%n".formatted());
        }
        else {
            for (Object item : items) {
                sb.append(item.toString());
                sb.append("");

            }
        }
        sb.append(String.format("%n TOTAL: $%.2f%n", getTotal()));
        sb.append(String.format(""));
        return sb.toString();
    }
}
