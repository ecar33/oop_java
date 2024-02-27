package pizza;

import java.util.ArrayList;
import java.util.Collections;

import pizza.sauce.PizzaSauce;
import pizza.topping.PizzaTopping;

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
