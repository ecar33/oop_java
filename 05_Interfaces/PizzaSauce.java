public abstract class PizzaSauce implements MenuItem {
    public abstract String toString();

    public String toNiceString() {
        return "Sauce is: " + this.toString() + " with price: $" + this.getPrice();
    }

    public Double getPrice(){
        return 0.50;
    }
}
