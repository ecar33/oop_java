package pizza;
import java.util.Scanner;

import pizza.factory.PizzaFactorySelector;
import pizza.factory.PizzaFactory;


public class PizzaMain {
    Pizza pizza;
    Scanner input;

    public PizzaMain() {
        this.pizza = new Pizza();
        this.input = new Scanner(System.in);
    }

    private void greetingMessage() {
        System.out.println("Welcome to Pepe's Pizza!");
    }

    private void inputToppingsChoice() {
        int userInput = 0;
        int toppingsCount = 0;
        boolean validInput;

        System.out.println("How many toppings would you like? (Maximum of 4)");
        validInput = false;
        while (!validInput) {
            try {
                userInput = Integer.parseInt(input.nextLine().trim());

                if (userInput < 1 || userInput > 4) {
                    System.out.println("Please input a number between 1 and 4.");
                } else {
                    validInput = true;
                    toppingsCount = userInput;
                }

            } catch (NumberFormatException e) {
                System.out.println("Failed to get correct input, try again.");
            }
        }

        while (toppingsCount > 0) {
            System.out.print("""
                    What kind of toppings would you like:
                        How many toppings?
                        1 - Sausage
                        2 - Pepperoni
                        3 - Squash
                        4 - Zucchini
                        5 - Pepper
                        6 - Mozzarella
                        7 - Cheddar
                        8 - Provolone
                        9 - Ham
                        10 - Bacon
                        11 - Tomato
                        12 - Havarti
                        13 - Display current chosen toppings
                    """);
            validInput = false;
            while (!validInput) {
                try {
                    userInput = Integer.parseInt(input.nextLine().trim());

                    if (userInput < 1 || userInput > 13) {
                        System.out.println("Please input a number between 1 and 13.");
                    } else {
                        validInput = true;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Failed to get correct input, try again.");
                }
            }

            if (userInput != 13) {
                toppingsCount -= 1;
                pizza.addToppingFromInt(userInput);
            } else {
                pizza.displayToppings();
            }
        }


    }

    private void inputSauceChoice() {
        int userInput = 0;

        System.out.println("""
                What kind of sauce would you like?
                1 - Tomato Sauce
                2 - Alfredo Sauce
                    """);
        boolean validInput = false;

        while (!validInput) {
            try {
                userInput = Integer.parseInt(input.nextLine().trim());

                if (userInput < 1 || userInput > 2) {
                    System.out.println("Please select between choice 1 and 2.");
                } else {
                    validInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Failed to get correct input, try again.");
            }
        }

        pizza.setSauceFromInt(userInput);

    }

    private void inputCrustChoice() {
        Boolean validInput = false;
        int userInput = 0;

        System.out.println("""
                What kind of crust would you like?
                1 - Thin Crust
                2 - Thick Crust
                    """);
        while (!validInput) {
            try {
                userInput = Integer.parseInt(input.nextLine().trim());

                if (userInput < 1 || userInput > 2) {
                    System.out.println("Please select between choice 1 and 2.");
                } else {
                    validInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Failed to get correct input, try again.");
            }
        }

        pizza.setCrustFromInt(userInput);
    }  

    private void buildCustomPizza() {
        inputToppingsChoice();
        inputCrustChoice();
        inputSauceChoice();
    }

    private int inputCreationChoice() {
        Boolean validInput = false;
        int userInput = 0;

        System.out.println("""
                Would you like to build your own pizza or choose one of our specials?
                1 - Build your own pizza
                2 - Choose a specialty pizza
                    """);
        while (!validInput) {
            try {
                userInput = Integer.parseInt(input.nextLine().trim());

                if (userInput < 1 || userInput > 2) {
                    System.out.println("Please select between choice 1 and 2.");
                } else {
                    validInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Failed to get correct input, try again.");
            }
        }
        return userInput;
    }

    private void buildSpecialityPizza() {
        Boolean validInput = false;
        int userInput = 0;

        System.out.println("""
                Which specialty pizza would you like?
                1 - Supreme Pizza
                2 - Hawaiian Pizza
                3 - Buffalo Chicken Pizza
                    """);
        while (!validInput) {
            try {
                userInput = Integer.parseInt(input.nextLine().trim());

                if (userInput < 1 || userInput > 3) {
                    System.out.println("Please select between choice 1 and 3.");
                } else {
                    validInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Failed to get correct input, try again.");
            }
        }
        
        PizzaFactory pizzaFactory = PizzaFactorySelector.selectFactory(userInput);
        pizza = pizzaFactory.buildPizza();

    }



    public void runMenu() {
        greetingMessage();
        int choice = inputCreationChoice();
        switch (choice) {
            case 1:
                buildCustomPizza();
                break;
            case 2:
                buildSpecialityPizza(); 
                break;
        }

        String pizzaString = showPizza();
        System.out.println(pizzaString);
    }

    private String showPizza() {
        return pizza.toNiceString();
    }

    public static void main(String[] args) {
        PizzaMain pm = new PizzaMain();
        pm.runMenu();

    }
}
