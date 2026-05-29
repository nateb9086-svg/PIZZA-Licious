package com.pluralsight.ui;

import com.pluralsight.model.Pizza;
import com.pluralsight.model.Pizza.*;

import java.util.List;

public class PizzaScreen {

    public static Pizza buildPizza() {

        System.out.println("");
        System.out.println("It's time to build your Pizza");
        System.out.println("");

        Pizza pizza = new Pizza();


        List<String> types = List.of("Thin Crust", "Regular Crust", "Thick Crust", "Cauliflower");

        int t = InputHelper.selectFromList("Select your type:", types, false);
        pizza.setType(Pizza.Type.values()[t]);

        List<String> sizes = List.of("Personal (8\") - $ 8.50", "Medium (12\") - $12.00", "Large (16\") - $16.50");

        int s = InputHelper.selectFromList("Pizza Size:", sizes, false);
        pizza.setSize(Pizza.Size.values()[s]);

        System.out.println("\n Toppings");
        addToppingGroup(pizza, "Meat", Pizza.meatOptions, pizza::addMeat);
        addToppingGroup(pizza, "Cheese", Pizza.cheeseOptions, pizza::addCheese);
        addToppingGroup(pizza, "Toppings", Pizza.toppingOptions, pizza::addTopping);
        addToppingGroup(pizza, "Sauces", Pizza.sauceOptions, pizza::addSauce);
        addToppingGroup(pizza, "Sides", Pizza.sideOptions, pizza::addSides);

        boolean stuffed = InputHelper.readYesNo(
                "\n Would you like stuffed crust?");
        pizza.setStuffedCrust(stuffed);

        System.out.println("\n Pizza added!");
        System.out.println(pizza);
        return pizza;

    }

    private static void addToppingGroup(Pizza pizza, String groupName,
                                        List<String> options,
                                        java.util.function.Consumer<String> adder){
        System.out.println("\n " + groupName + ": ");
        for (int i = 0; i < options.size(); i++){
            System.out.printf("  %d) %s%n", i + 1, options.get(i));
        }
        System.out.println("  0) Done");

        while (true) {
            int choice = InputHelper.readInt("  Select " + groupName + " (0 when done): ", 0, options.size());
            if (choice == 0) break;
            String name = options.get(choice - 1);
            adder.accept(name);
            System.out.println(" Added " + name + ".\n Select another or 0 to continue.");
        }
    }
}
