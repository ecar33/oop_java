package pizza.factory;

import java.util.Map;
import java.util.HashMap;

public class PizzaFactoryMap {
    private Map<Integer, String> factoryTypes;

    public PizzaFactoryMap() {
        factoryTypes = new HashMap<>();
        initialize();
    }

    private void initialize() {
        factoryTypes.put(1, "supreme");
        factoryTypes.put(2, "hawaiian");
        factoryTypes.put(3, "buffalo chicken");
    }

    public String getFactoryType(int userInput) {
        return factoryTypes.getOrDefault(userInput, null);
    }
}
