package com.mycompany.app.easy.coffee_vending_machine.coffee;

import java.util.List;

public abstract class Coffee {
    
    public abstract int getPrice();
    public abstract String getName();
    public abstract List<Ingredient> getRecipe();
}
