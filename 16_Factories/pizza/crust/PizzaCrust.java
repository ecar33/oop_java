package pizza.crust;

import pizza.MenuItem;

public abstract class PizzaCrust implements MenuItem {
    private String ingredient;
    private Boolean deepDishValue = false;

    public abstract String toString();

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setDeepDish(boolean bool) {
        this.deepDishValue = bool;
    }

    public Boolean getDeepDish() {
        return deepDishValue;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String toNiceString() {
        return "Crust is: " + this.toString() + " with price: $" + this.getPrice();
    }

    public Double getPrice() {
        return 1.00;
    }

}
