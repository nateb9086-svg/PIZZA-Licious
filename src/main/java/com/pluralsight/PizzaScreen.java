package com.pluralsight;

import java.util.List;

public class PizzaScreen {

    public static buildPizza() {

        System.out.println("");
        System.out.println("It's time to build your Pizza");
        System.out.println("");

        Pizza pizza = new Pizza();


        List<String> types = List.of("Thin Crust", "Regular Crust", "Thick Crust", "cauliflower");

        int t = InputHelper.selectFromList("Select your type:", types, false);
        pizza.setType(Pizza.Type.values()[t]);

        List<String> sizes = List.of("Small (8\") - $ 8.50", "Medium (12\") - $12.00", "Large (16\") - $16.50");




    }
}
