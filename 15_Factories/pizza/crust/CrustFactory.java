package pizza.crust;

import java.lang.reflect.InvocationTargetException;

public class CrustFactory {
    private CrustMap crustMap;

    public CrustFactory(CrustMap crustMap) {
        this.crustMap = crustMap;
    }

    public PizzaCrust createCrust(int userInput) {
        String crustType = crustMap.getCrustType(userInput);

        if (crustType == null) {
            System.out.println("Incorrect input for crust.");
            return null;
        }

        try {
            Class<?> loadClass = Class.forName("pizza.crust." + crustType + "Crust");
            return (PizzaCrust) loadClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Cannot create crust of type " + crustType);
            e.printStackTrace();
        }
        return null;
    }

}
