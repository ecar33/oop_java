package pizza.topping;

import java.util.Map;
import java.util.HashMap;

public class ToppingMap {
    private Map<Integer, String> toppingTypes;

    public ToppingMap() {
        toppingTypes = new HashMap<>();
        initialize();
    }

    private void initialize() {
        toppingTypes.put(1, "Sausage");
        toppingTypes.put(2, "Pepperoni");
        toppingTypes.put(3, "Squash");
        toppingTypes.put(4, "Zucchini");
        toppingTypes.put(5, "Pepper");
        toppingTypes.put(6, "Mozzarella");
        toppingTypes.put(7, "Cheddar");
        toppingTypes.put(8, "Provolone");
        toppingTypes.put(9, "Ham");
        toppingTypes.put(10, "Bacon");
        toppingTypes.put(11, "Tomato");
        toppingTypes.put(12, "Havarti");
        toppingTypes.put(13, "GreenBellPepper");
        toppingTypes.put(14, "RedOnion");
        toppingTypes.put(15, "BlackOlive");
        toppingTypes.put(16, "Cheese");
        toppingTypes.put(17, "GoudaCheese");
        toppingTypes.put(18, "Havarti");
        toppingTypes.put(19, "Meat");
        toppingTypes.put(20, "Veggie");
        toppingTypes.put(21, "BleuCheese");
        toppingTypes.put(22, "Pineapple");
        toppingTypes.put(23, "Mushroom");
        toppingTypes.put(24, "Onion");
        toppingTypes.put(25, "Chicken");
    }

    public String getToppingType(int userInput) {
        return toppingTypes.get(userInput);
    }
    
}
