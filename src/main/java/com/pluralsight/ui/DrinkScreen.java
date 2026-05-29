package com.pluralsight.ui;

import com.pluralsight.model.Drink;

import java.util.List;

public class DrinkScreen {

    public static Drink buildDrink(){
        System.out.println("");
        System.out.println(" ADD A DRINK ");
        System.out.println("");

        List<String> sizes = List.of("Small - $2.00", "Medium - $2.50", "Large - $3.00" );

        int s = InputHelper.selectFromList("Select Size:", sizes, false);
        Drink.Size size = Drink.Size.values()[s];

        int f = InputHelper.selectFromList("Select Flavor:", Drink.flavorOptions, false);
        String flavor = Drink.flavorOptions.get(f);

        Drink drink = new Drink(size, flavor);
        System.out.println("\n Drink Added!");
        System.out.print(drink);
        return drink;


    }
}
