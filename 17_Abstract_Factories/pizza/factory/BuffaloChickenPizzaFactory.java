package pizza.factory;

import pizza.crust.PizzaCrust;
import pizza.sauce.PizzaSauce;
import pizza.topping.PizzaTopping;
import pizza.sauce.SauceFactory;
import pizza.crust.CrustFactory;
import pizza.topping.ToppingFactory;
import java.util.ArrayList;

public class BuffaloChickenPizzaFactory extends PizzaFactory {
    public PizzaCrust createCrust() {
        // Create thin crust
        return CrustFactory.createCrust(1); 
    }

    public PizzaSauce createSauce() {
        // Create ranch sauce
        return SauceFactory.createSauce(3); 
    }

    public ArrayList<PizzaTopping> createToppings() {
        ArrayList<PizzaTopping> toppings = new ArrayList<>();

        toppings.add(ToppingFactory.createTopping(21)); // Bleu Cheese
        toppings.add(ToppingFactory.createTopping(25)); // Chicken
        toppings.add(ToppingFactory.createTopping(17)); // Gouda Cheese
        toppings.add(ToppingFactory.createTopping(14)); // Red onion
        
        return toppings;
    }
}

// bleu cheese, chicken, gouda cheese, red onion