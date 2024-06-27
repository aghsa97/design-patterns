package com.mycompany.app.easy.coffee_vending_machine.coffee;

import java.util.ArrayList;
import java.util.List;

public class Latte extends Coffee {
    private final String name = "Latte";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return 10;
    }

    @Override
    public List<Ingredient> getRecipe() {
        List<Ingredient> recipe = new ArrayList<Ingredient>();
        recipe.add(new Ingredient("Coffee", 1));
        recipe.add(new Ingredient("Milk", 2));
        return recipe;
    }
    
}
