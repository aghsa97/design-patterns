package com.mycompany.app.easy.coffee_vending_machine.coffee.creators;

import com.mycompany.app.easy.coffee_vending_machine.coffee.Coffee;

public abstract class CoffeeCreator {
    public Coffee getCoffee() {
        return createCoffee();
    }

    public abstract Coffee createCoffee();
}
