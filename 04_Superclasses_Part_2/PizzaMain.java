import java.util.ArrayList;
import java.util.Scanner;

public class PizzaMain {
    private Pizza pizza;
    private Scanner input;

    private void inputToppingsChoice() {
        int userInput = 0;
        ArrayList<PizzaTopping> toppings = new ArrayList<>();
        int toppingsCount = 0;
        PizzaTopping topping;
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

        while (toppingsCount != 0) {
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

            switch (userInput) {
                case 1:
                    topping = new SausageTopping();
                    toppings.add(topping);
                    break;
                case 2:
                    topping = new PepperoniTopping();
                    toppings.add(topping);
                    break;
                case 3:
                    topping = new SquashTopping();
                    toppings.add(topping);
                    break;
                case 4:
                    topping = new ZucchiniTopping();
                    toppings.add(topping);
                    break;
                case 5:
                    topping = new PepperTopping();
                    toppings.add(topping);
                    break;
                case 6:
                    topping = new MozzarellaTopping();
                    toppings.add(topping);
                    break;
                case 7:
                    topping = new CheddarTopping();
                    toppings.add(topping);
                    break;
                case 8:
                    topping = new ProvoloneTopping();
                    toppings.add(topping);
                    break;
                case 9:
                    topping = new HamTopping();
                    toppings.add(topping);
                    break;
                case 10:
                    topping = new BaconTopping();
                    toppings.add(topping);
                    break;
                case 11:
                    topping = new TomatoTopping();
                    toppings.add(topping);
                    break;
                case 12:
                    topping = new HavartiTopping();
                    toppings.add(topping);
                    break;
                case 13:
                    if (toppings.isEmpty()) {
                        System.out.println("You haven't selected any toppings yet!");
                    } else {
                        for (PizzaTopping top : toppings) {
                            System.out.println(top.toString());
                        }
                    }
                    break;
                default:
                    System.out.println("Incorrect input for topping.");
                    break;
            }

            if (userInput != 13) {
                toppingsCount -= 1;
            }
        }

        pizza.setToppings(toppings);

    }

    private void inputSauceChoice() {
        int userInput = 0;
        PizzaSauce sauce;

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

        switch (userInput) {
            case 1:
                sauce = new TomatoSauce();
                pizza.setSauce(sauce);
                System.out.println(sauce.toNiceString());
                break;
            case 2:
                sauce = new AlfredoSauce();
                pizza.setSauce(sauce);
                System.out.println(sauce.toNiceString());
                break;
        }

    }

    private void inputCrustChoice() {
        Boolean validInput = false;
        int userInput = 0;
        PizzaCrust crust;

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

        switch (userInput) {
            case 1:
                crust = new ThinCrust();
                pizza.setCrust(crust);
                System.out.println(crust.toNiceString());
                break;
            case 2:
                crust = new ThickCrust();
                pizza.setCrust(crust);
                inputDeepDish();
                System.out.println(crust.toNiceString());
                break;
            default:
                System.out.println("\nInvalid option selected\n");
        }
    }

    private void inputCrustIngredient() {
        Boolean validInput = false;
        int userInput = 0;
        PizzaCrust crust = pizza.getCrust();
        System.out.println("""
                What kind of crust ingredient would you like?
                1 - All Purpose Flour
                2 - Whole Wheat Flour
                3 - Cauliflower
                    """);

        while (!validInput) {
            try {
                userInput = Integer.parseInt(input.nextLine().trim());

                if (userInput < 1 || userInput > 3) {
                    System.out.println("Please select between choice 1 and 2.");
                } else {
                    validInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Failed to get correct input, try again.");
            }

            switch (userInput) {
                case 1:
                    crust.setIngredient("All Purpose Flour");
                    System.out.println(crust.getIngredient());
                    break;
                case 2:
                    crust.setIngredient("Whole Wheat Flour");
                    System.out.println(crust.getIngredient());
                    break;
                case 3:
                    crust.setIngredient("Cauliflower");
                    System.out.println(crust.getIngredient());
                    break;
                default:
                    System.out.println("\nInvalid option selected\n");
            }
        }

    }

    private void inputDeepDish() {
        Boolean validInput = false;
        String userInputString = null;
        PizzaCrust crust = pizza.getCrust();

        System.out.println("""
                Would you like deep dish crust?
                - (y)
                - (n)
                    """);
        while (!validInput) {
            userInputString = input.nextLine().trim();

            if (!userInputString.isEmpty()) {
                char decision = userInputString.charAt(0);

                switch (decision) {
                    case 'y':
                        crust.setDeepDish(true);
                        validInput = true;
                        break;
                    case 'n':
                        crust.setDeepDish(false);
                        validInput = true;
                        break;
                    default:
                        System.out.println("Please enter yes/no only.");
                }
            } else {
                System.out.println("Input cannot be empty, try again.");
            }
        }
    }

    public PizzaMain() {
        pizza = new Pizza();
        input = new Scanner(System.in);
    }

    public void runMenu() {
        inputToppingsChoice();
        inputCrustChoice();
        inputCrustIngredient();
        inputSauceChoice();
        showPizza();
    }

    private void showPizza() {
        pizza.getPizzaInfo();
    }

    public static void main(String[] args) {
        PizzaMain pm = new PizzaMain();
        pm.runMenu();

    }
}
