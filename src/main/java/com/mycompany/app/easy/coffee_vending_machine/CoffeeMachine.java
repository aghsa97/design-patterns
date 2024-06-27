package com.mycompany.app.easy.coffee_vending_machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.app.easy.coffee_vending_machine.coffee.Coffee;
import com.mycompany.app.easy.coffee_vending_machine.coffee.Ingredient;
import com.mycompany.app.easy.coffee_vending_machine.coffee.creators.CappuccinoCreator;
import com.mycompany.app.easy.coffee_vending_machine.coffee.creators.EspressoCreator;
import com.mycompany.app.easy.coffee_vending_machine.coffee.creators.LatteCreator;

public class CoffeeMachine {
    private static CoffeeMachine instance;
    private final Map<String, Ingredient> ingredients;
    private final List<Coffee> coffeeMenu;

    private CoffeeMachine() {
        ingredients = new HashMap<>();
        coffeeMenu = new ArrayList<>();
        initializeIngredients();
        initializeMenu();
    }

    private void initializeIngredients() {
        ingredients.put("Coffee", new Ingredient("Coffee", 10));
        ingredients.put("Milk", new Ingredient("Milk", 20));
        ingredients.put("Water", new Ingredient("Water", 30));
    }

    private void initializeMenu() {
        coffeeMenu.add(new EspressoCreator().getCoffee());
        coffeeMenu.add(new LatteCreator().getCoffee());
        coffeeMenu.add(new CappuccinoCreator().getCoffee());
    }

    public static synchronized CoffeeMachine getInstance() {
        if (instance == null) {
            instance = new CoffeeMachine();
        }
        return instance;
    }

    public void displayMenu() {
        System.out.println("Coffee Menu:");
        for (Coffee coffee : coffeeMenu) {
            System.out.println(coffee.getName() + " - $" + coffee.getPrice());
        }
    }

    public synchronized void orderCoffee(Coffee coffee, Payment payment) {
        if (payment.getAmount() >= coffee.getPrice()) {
            if (hasEnoughIngredients(coffee)) {
                updateIngredients(coffee);
                System.out.println("Preparing " + coffee.getName() + "...");
                double change = payment.getAmount() - coffee.getPrice();
                if (change > 0) {
                    System.out.println("Please collect your change: $" + change);
                }
            } else {
                System.out.println("Insufficient ingredients to make " + coffee.getName());
            }
        } else {
            System.out.println("Insufficient payment for " + coffee.getName());
        }
    }

    private boolean hasEnoughIngredients(Coffee coffee) {
        List<Ingredient> recipe = coffee.getRecipe();
        for (Ingredient reqIngredient : recipe) {
            Ingredient avaIngredient = ingredients.get(reqIngredient.getName());
            if (reqIngredient.getQuantity() > avaIngredient.getQuantity()) {
                return false;
            }
        }
        return true;
    }

    private void updateIngredients(Coffee coffee) {
        List<Ingredient> recipe = coffee.getRecipe();
        for (Ingredient reqIngredient : recipe) {
            Ingredient ingredient = ingredients.get(reqIngredient.getName());
            ingredient.updateQuantity(-reqIngredient.getQuantity());
            if (ingredient.getQuantity() < 3) {
                System.out.println("Low inventory alert: " + ingredient.getName());
            }
        }
    }
    
}
