package com.pizzaburger.pizza;
import com.pizzaburger.burger.topping.BaconTopping;
import com.pizzaburger.menuitem.AbstractMenuItem;
import com.pizzaburger.pizza.crust.*;
import com.pizzaburger.pizza.topping.*;
import com.pizzaburger.pizza.sauce.*;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PizzaTest {

    private Pizza pizza;

    @Before
    public void setUp() throws Exception {
        pizza = new Pizza();
        pizza.addComponent(new ThinCrust()); 
        pizza.addComponent(new TomatoSauce()); 
        pizza.addComponent(new BaconTopping());
        pizza.addComponent(new SausageTopping());
    }

    @Test
    public void testDisplaySorted() {
        // Directly test the sorting functionality by examining the sorted list
        pizza.displaySorted();
        ArrayList<AbstractMenuItem> components = pizza.getComponents();

        for (int i = 0; i < components.size() - 1; i += 1) {
            assertTrue("Components should be assorted in ascending order",
            components.get(i).getPrice() <= components.get(i+1).getPrice());
        }
    }
}