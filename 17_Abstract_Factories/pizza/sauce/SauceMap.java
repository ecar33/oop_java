package pizza.sauce;

import java.util.Map;
import java.util.HashMap;

public class SauceMap {
    private Map<Integer, String> sauceTypes;

    public SauceMap() {
        sauceTypes = new HashMap<>();
        initialize();
    }

    private void initialize() {
        sauceTypes.put(1, "Tomato");
        sauceTypes.put(2, "Alfredo");
        sauceTypes.put(3, "Ranch");
    }

    public String getSauceType(int userInput) {
        return sauceTypes.get(userInput);
    }
    
}
