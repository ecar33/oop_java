package pizza.sauce;

import java.lang.reflect.InvocationTargetException;

public class SauceFactory {
    private static SauceMap sauceMap = new SauceMap();

    public static PizzaSauce createSauce(int userInput) {
        String sauceType = sauceMap.getSauceType(userInput);

        if (sauceType == null) {
            System.out.println("Incorrect input for sauce.");
            return null;
        }

        try {
            String className = "pizza.sauce." + sauceType + "Sauce";
            Class<?> sauceClass = Class.forName(className);
            return (PizzaSauce) sauceClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error creating sauce of type " + sauceType);
            e.printStackTrace();
        }
        return null;
    }

}
