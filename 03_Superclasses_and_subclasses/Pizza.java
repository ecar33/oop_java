import java.util.ArrayList;

public class Pizza {
    ArrayList<PizzaTopping> toppings = new ArrayList<>();
    PizzaCrust crust;
    PizzaSauce sauce;

    public Pizza(ArrayList<PizzaTopping> toppings, PizzaCrust crust, PizzaSauce sauce) {
        this.toppings = toppings;
        this.crust = crust;
        this.sauce = sauce;
    }

    public void getPizza() {
        System.out.println("Your pizza is ready!");
        System.out.println("********************");
        String toppingsString = "Toppings:\n";

        if (!toppings.isEmpty()) {
            for (PizzaTopping topping : toppings) {
                toppingsString += topping.toString() + '\n';
            }
            System.out.println(toppingsString);
        }
        if (crust != null) {
            System.out.println("Crust: " + crust.toString() + "\n");
        }
        if (sauce != null) {
            System.out.println("Sauce: " + sauce.toString());
        }
    }

}
