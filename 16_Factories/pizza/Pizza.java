package pizza;

import java.util.ArrayList;
import java.util.Collections;

import pizza.crust.PizzaCrust;
import pizza.sauce.PizzaSauce;
import pizza.topping.PizzaTopping;

import pizza.topping.ToppingFactory;
import pizza.topping.ToppingMap;

import pizza.sauce.SauceMap;
import pizza.sauce.SauceFactory;

import pizza.crust.CrustMap;
import pizza.crust.CrustFactory;

public class Pizza implements MenuItem {
	private PizzaCrust crust;
	private PizzaSauce sauce;
	private ArrayList<PizzaTopping> toppings;
	private ArrayList<MenuItem> menuItems;
	
	private ToppingFactory toppingFactory;
	private ToppingMap toppingMap;

	private SauceMap sauceMap;
	private SauceFactory sauceFactory;

	private CrustMap crustMap;
	private CrustFactory crustFactory;

	public Pizza() {
		this.crust = null;
		this.sauce = null;
		this.toppings = new ArrayList<PizzaTopping>();
		this.menuItems = new ArrayList<MenuItem>();
		this.toppingMap = new ToppingMap();
		this.toppingFactory = new ToppingFactory(toppingMap);
		this.toppings = new ArrayList<>();
		this.sauceMap = new SauceMap();
		this.sauceFactory = new SauceFactory(sauceMap);
		this.crustMap = new CrustMap();
		this.crustFactory = new CrustFactory(crustMap);
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

	public void setCrust(int userInput) {
		PizzaCrust crust = crustFactory.createCrust(userInput);
		if (crust != null) {
			addMenuItem(crust);
			System.out.println("Added " + crust.getClass().getSimpleName());
		}
		this.crust = crust;
	}

	public PizzaSauce getSauce() {
		return this.sauce;
	}

	public void setSauce(int userInput) {
		PizzaSauce sauce = sauceFactory.createSauce(userInput);
		if (sauce != null) {
			addMenuItem(sauce);
			System.out.println("Added " + sauce.getClass().getSimpleName());
		}
		this.sauce = sauce;
	}

	public ArrayList<PizzaTopping> getToppings() {
		return this.toppings;
	}

	public void setToppings(ArrayList<PizzaTopping> toppings) {
		this.toppings = toppings;
	}

	public void addTopping(int userInput) {
		PizzaTopping topping = toppingFactory.createTopping(userInput);
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
