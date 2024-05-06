package pizza;

import java.util.ArrayList;
import java.util.Collections;
import pizza.crust.PizzaCrust;
import pizza.sauce.PizzaSauce;
import pizza.topping.PizzaTopping;
import pizza.topping.ToppingFactory;
import pizza.sauce.SauceFactory;
import pizza.crust.CrustFactory;

public class Pizza implements MenuItem {
	private PizzaCrust crust;
	private PizzaSauce sauce;
	private ArrayList<PizzaTopping> toppings;
	private ArrayList<MenuItem> menuItems;

	public Pizza() {
		this.crust = null;
		this.sauce = null;
		this.toppings = new ArrayList<PizzaTopping>();
		this.menuItems = new ArrayList<MenuItem>();
	}

	public Double getPrice() {
		Double totalPrice = 0.0;

		for (MenuItem item : menuItems) {
			totalPrice += item.getPrice();
		}

		return totalPrice;

	}

	public void addMenuItem(MenuItem item) {
		menuItems.add(item);
	}

	public PizzaCrust getCrust() {
		return this.crust;
	}

	public void setCrustFromInt(int userInput) {
		PizzaCrust crust = CrustFactory.createCrust(userInput);
		if (crust != null) {
			addMenuItem(crust);
			System.out.println("Added " + crust.getClass().getSimpleName());
		}
		this.crust = crust;
	}

	public PizzaSauce getSauce() {
		return this.sauce;
	}

	public void setSauceFromInt(int userInput) {
		PizzaSauce sauce = SauceFactory.createSauce(userInput);
		if (sauce != null) {
			addMenuItem(sauce);
			System.out.println("Added " + sauce.getClass().getSimpleName());
		}
		this.sauce = sauce;
	}

	public void setCrust(PizzaCrust crust) {
		this.crust = crust;
		addMenuItem(crust);

	}

	public void setSauce(PizzaSauce sauce) {
		this.sauce = sauce;
		addMenuItem(sauce);

	}

	public void addTopping(PizzaTopping topping) {
		toppings.add(topping);
		addMenuItem(topping);

	}

	public ArrayList<PizzaTopping> getToppings() {
		return this.toppings;
	}

	public void setToppings(ArrayList<PizzaTopping> toppings) {
		this.toppings = toppings;
		for (PizzaTopping top : toppings) {
			addMenuItem(top);
		}
	}

	public void addToppingFromInt(int userInput) {
		PizzaTopping topping = ToppingFactory.createTopping(userInput);
		if (topping != null) {
			addMenuItem(topping);
			toppings.add(topping);
			System.out.println("Added " + topping.getClass().getSimpleName());
		}
	}

	public void displayToppings() {
		if (toppings.isEmpty()) {
			System.out.println("No toppings have been added yet.");
		} else {
			for (PizzaTopping top : toppings) {
				System.out.println(top.toString());
			}
		}
	}

	public void sortMenuItemsByPrice() {
		Collections.sort(this.menuItems, new MenuItemPriceComparator());
	}

	public String toNiceString() {
		String result = "";
		System.out.println("\nYour pizza is ready!");
		System.out.println("********************");
		sortMenuItemsByPrice();

		for (MenuItem item : this.menuItems) {
			result += item.toNiceString() + '\n';
		}

		return result;
	}

}
