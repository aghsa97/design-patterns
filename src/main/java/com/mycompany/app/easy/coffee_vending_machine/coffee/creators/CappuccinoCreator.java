package com.mycompany.app.easy.coffee_vending_machine.coffee.creators;

import com.mycompany.app.easy.coffee_vending_machine.coffee.Cappuccino;
import com.mycompany.app.easy.coffee_vending_machine.coffee.Coffee;

public class CappuccinoCreator extends CoffeeCreator {
    @Override
    public Coffee createCoffee() {
        return new Cappuccino();
    }
}
