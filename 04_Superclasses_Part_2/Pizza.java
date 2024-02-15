import java.util.ArrayList;

public class Pizza {
	private PizzaCrust crust;
	private PizzaSauce sauce;
	private ArrayList<PizzaTopping> toppings;
	
	public Pizza() {
		this.crust = null;
		this.sauce = null;
		this.toppings = new ArrayList<PizzaTopping>();
	}

	public PizzaCrust getCrust() {
		return this.crust;
	}

	public void setCrust(PizzaCrust crust) {
		this.crust = crust;
	}

	public PizzaSauce getSauce() {
		return this.sauce;
	}

	public void setSauce(PizzaSauce sauce) {
		this.sauce = sauce;
	}

	public ArrayList<PizzaTopping> getToppings() {
		return this.toppings;
	}

	public void setToppings(ArrayList<PizzaTopping> toppings) {
		this.toppings = toppings;
	}

	public void addTopping(PizzaTopping topping) {
		this.toppings.add(topping);
	}

    public void getPizzaInfo() {
        System.out.println("\nYour pizza is ready!");
        System.out.println("********************");

        if (!toppings.isEmpty()) {
            for (PizzaTopping topping : toppings) {
				System.out.println(topping.toNiceString());
            }
        }
        if (crust != null) {
            System.out.println(crust.toNiceString());
            System.out.println("Made with: " + crust.getIngredient());

            if (crust.toString() == "Thick Crust") {
                System.out.println("Deep Dish Style: " + crust.getDeepDish());
            }
        }
        if (sauce != null) {
            System.out.println(sauce.toNiceString());
        }
    }

}
