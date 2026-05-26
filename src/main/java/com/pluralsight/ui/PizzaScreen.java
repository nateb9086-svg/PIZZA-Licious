package com.pluralsight.ui;

import com.pluralsight.InputHelper;
import com.pluralsight.model.Pizza;

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

        List<String> sizes = List.of("Personal (8\") - $ 8.50", "Medium (12\") - $12.00", "Large (16\") - $16.50");

        int s = InputHelper.selectFromList("Pizza size:", sizes, false);
        pizza.setSize(Pizza.Size.values()[s]);

        System.out.println("\n Toppings");
        addToppingGroup(pizza, "Meat", Pizza.meatOptions, pizza::addMeat);
        addToppingGroup(pizza, "Cheese", Pizza.cheeseOptions, pizza::addCheese);
        addToppingGroup(pizza, "Toppings", Pizza.toppingOptions, pizza::addTopping);
        addToppingGroup(pizza, "Sauces", Pizza.sauceOptions, pizza::addSauce);

        boolean stuffed = InputHelper.readYesNo(
                "\n Would you like stuffed crust?");
        pizza.setStuffedCrust(stuffed);




    }
}
