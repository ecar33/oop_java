package pizza.factory;

public class PizzaFactorySelector {
    private static PizzaFactoryMap factoryMap = new PizzaFactoryMap();

    public static PizzaFactory selectFactory(int type) {
        String factoryName = factoryMap.getFactoryType(type);
        if (factoryName == null) {
            throw new IllegalArgumentException("Unknown pizza type: " + type);
        }
        switch (factoryName) {
            case "supreme":
                return new SupremePizzaFactory();
            case "hawaiian":
                return new HawaiianPizzaFactory();
            case "buffalo chicken":
                return new BuffaloChickenPizzaFactory();
            default:
                throw new IllegalArgumentException("Configuration error: Unhandled pizza type: " + factoryName);
        }
    }
}