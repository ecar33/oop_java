package pizza.crust;

import java.lang.reflect.InvocationTargetException;

public class CrustFactory {
    private static CrustMap crustMap = new CrustMap();

    public static PizzaCrust createCrust(int userInput) {
        String crustType = crustMap.getCrustType(userInput);

        if (crustType == null) {
            System.out.println("Incorrect input for crust.");
            return null;
        }

        try {
            String className = "pizza.crust." + crustType + "Crust";
            Class<?> crustClass = Class.forName(className);
            return (PizzaCrust) crustClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Error creating crust of type " + crustType);
            e.printStackTrace();
        }
        return null;
    }

}
