package pizza.topping;

import java.lang.reflect.InvocationTargetException;

public class ToppingFactory {
    private static ToppingMap toppingMap = new ToppingMap();

    public static PizzaTopping createTopping(int userInput) {
        String toppingType = toppingMap.getToppingType(userInput);

        if (toppingType == null) {
            System.out.println("Incorrect input for topping.");
            return null;
        }

        try {
            // Ensure that the class name is correctly formatted and safe to use
            String className = "pizza.topping." + toppingType + "Topping";
            Class<?> toppingClass = Class.forName(className);
            return (PizzaTopping) toppingClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println("Error creating topping of type: " + toppingType);
            e.printStackTrace();
        }
        return null;
    }
}