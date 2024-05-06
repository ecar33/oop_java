package pizza.factory;

import pizza.crust.PizzaCrust;
import pizza.sauce.PizzaSauce;
import pizza.topping.PizzaTopping;
import pizza.sauce.SauceFactory;
import pizza.crust.CrustFactory;
import pizza.topping.ToppingFactory;
import java.util.ArrayList;

public class SupremePizzaFactory extends PizzaFactory {
    public PizzaCrust createCrust() {
        // Create thin crust
        return CrustFactory.createCrust(1);
    }

    public PizzaSauce createSauce() {
        // Create tomato sauce
        return SauceFactory.createSauce(1);
    }

    public ArrayList<PizzaTopping> createToppings() {
        ArrayList<PizzaTopping> toppings = new ArrayList<>();

        toppings.add(ToppingFactory.createTopping(6)); // Mozzarella
        toppings.add(ToppingFactory.createTopping(2)); // Pepperoni
        toppings.add(ToppingFactory.createTopping(1)); // Sausage
        toppings.add(ToppingFactory.createTopping(23)); // Mushrooms
        toppings.add(ToppingFactory.createTopping(24)); // Onions
        toppings.add(ToppingFactory.createTopping(15)); // Black Olives
        toppings.add(ToppingFactory.createTopping(13)); // Green Bell Pepper
        return toppings;
    }
}