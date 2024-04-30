package pizza.sauce;

import java.lang.reflect.InvocationTargetException;

public class SauceFactory {
    private SauceMap sauceMap;

    public SauceFactory(SauceMap sauceMap) {
        this.sauceMap = sauceMap;
    }

    public PizzaSauce createSauce(int userInput) {
        String sauceType = sauceMap.getSauceType(userInput);

        if (sauceType == null) {
            System.out.println("Incorrect input for sauce.");
            return null;
        }

        try {
            Class<?> loadClass = Class.forName("pizza.sauce." + sauceType + "Sauce");
            return (PizzaSauce) loadClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Cannot create sauce of type " + sauceType);
            e.printStackTrace();
        }
        return null;
    }

}
