package pizza.crust;

import java.util.HashMap;
import java.util.Map;

public class CrustMap {
        private Map<Integer, String> crustTypes;

    public CrustMap() {
        crustTypes = new HashMap<>();
        initialize();
    }

    private void initialize() {
        crustTypes.put(1, "Thin");
        crustTypes.put(2, "Thick");
    }

    public String getCrustType(int userInput) {
        return crustTypes.get(userInput);
    }
}
