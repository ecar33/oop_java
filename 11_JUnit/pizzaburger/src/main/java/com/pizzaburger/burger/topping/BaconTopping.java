package com.pizzaburger.burger.topping;

/**
 * {@code BaconTopping} represents bacon
 */
public class BaconTopping extends MeatTopping {
	public String toString() {
		return "Bacon Topping";
	}


	@Override
	public Double getPrice() {
		return 1.0; 
	}

}
