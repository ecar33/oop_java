package com.pizzaburger.pizza.topping;
import com.pizzaburger.menuitem.AbstractMenuItem;

/**
 * {@code PizzaTopping} represents all possible toppings that can go on a pizza
 */
public abstract class PizzaTopping extends AbstractMenuItem {
	public abstract String toString(); 
	
	public String toNiceString() {
		return "Topping is: " + toString();
	}

	public Double getPrice() {
		return 1.00; // default price for topping
	}
}
