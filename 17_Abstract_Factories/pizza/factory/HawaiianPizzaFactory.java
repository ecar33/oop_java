package pizza.factory;

import pizza.crust.PizzaCrust;
import pizza.sauce.PizzaSauce;
import pizza.topping.PizzaTopping;
import pizza.sauce.SauceFactory;
import pizza.crust.CrustFactory;
import pizza.topping.ToppingFactory;
import java.util.ArrayList;

public class HawaiianPizzaFactory extends PizzaFactory {
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
        toppings.add(ToppingFactory.createTopping(9)); // Ham
        toppings.add(ToppingFactory.createTopping(22)); // Pineapple


        return toppings;
    }
}