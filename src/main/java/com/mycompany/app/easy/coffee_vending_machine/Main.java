package com.mycompany.app.easy.coffee_vending_machine;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
        coffeeMachine.displayMenu();
    }
}
