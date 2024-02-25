package pizza.topping;
public abstract class PizzaTopping implements MenuItem{
    public abstract String toString();

    public String toNiceString() {
        return "Topping is: " + this.toString() + " with price: $" + this.getPrice();
    }

    public Double getPrice() {
        return 1.50;
    }

}

