package pizza.topping;

import java.lang.reflect.InvocationTargetException;

public class ToppingFactory {
    private ToppingMap toppingMap;

    public ToppingFactory(ToppingMap toppingMap) {
        this.toppingMap = toppingMap;
    }

    public PizzaTopping createTopping(int userInput) {
        String toppingType = toppingMap.getToppingType(userInput);

        if (toppingType == null) {
            System.out.println("Incorrect input for topping.");
            return null;
        }

        try {
            Class<?> loadClass = Class.forName("pizza.topping." + toppingType + "Topping");
            return (PizzaTopping) loadClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Cannot create topping of type " + toppingType);
            e.printStackTrace();
        }
        return null;
    }

}
