package pizza.factory;

import pizza.Pizza;
import pizza.crust.PizzaCrust;
import pizza.sauce.PizzaSauce;
import pizza.topping.PizzaTopping;
import java.util.ArrayList;

public abstract class PizzaFactory {
    abstract PizzaCrust createCrust();
    abstract PizzaSauce createSauce();
    abstract ArrayList<PizzaTopping> createToppings();
    
    public Pizza buildPizza() {
        Pizza pizza = new Pizza();
        pizza.setCrust(createCrust());
        pizza.setSauce(createSauce());
        pizza.setToppings(createToppings());
        return pizza;
    }
}
