package com.mycompany.app.easy.coffee_vending_machine.coffee.creators;

import com.mycompany.app.easy.coffee_vending_machine.coffee.Coffee;
import com.mycompany.app.easy.coffee_vending_machine.coffee.Latte;

public class LatteCreator extends CoffeeCreator {
    @Override
    public Coffee createCoffee() {
        return new Latte();
    }
}
