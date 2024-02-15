public abstract class PizzaSauce {
    public abstract String toString();

    public String toNiceString() {
        return "Sauce is: " + this.toString();
    }
}
