package com.mycompany.app.easy.coffee_vending_machine.coffee;

import java.util.ArrayList;
import java.util.List;

public class Cappuccino extends Coffee {
    private final String name = "cappuccino";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return 15;
    }

    @Override
    public List<Ingredient> getRecipe() {
        List<Ingredient> recipe = new ArrayList<Ingredient>();
        recipe.add(new Ingredient("Coffee", 2));
        recipe.add(new Ingredient("Milk", 2));
        return recipe;
    }
    
}
