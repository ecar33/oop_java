import java.util.ArrayList;
import java.util.Scanner;

public class PizzaMain {
    public static void main(String[] args) {
        int userInput = 0;
        String userInputString = "";
        Scanner input = new Scanner(System.in);
        Pizza pizza = null;
        ArrayList<PizzaTopping> toppings = new ArrayList<>();
        PizzaCrust crust = null;
        PizzaSauce sauce = null;
        boolean moreToppings = true;
        int toppingsCount = 0;

        while (moreToppings && toppingsCount < 4) {
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
            boolean validInput = false;
            while (!validInput) {
                try {
                    userInput = Integer.parseInt(input.nextLine().trim());

                    if (userInput < 1 || userInput > 13) {
                        System.out.println("Please input a number between 1 and 12.");
                    } else {
                        validInput = true;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Failed to get correct input, try again.");
                }
            }

            switch (userInput) {
                case 1:
                    toppings.add(new SausageTopping());
                    System.out.println("Added Sausage topping.");
                    break;
                case 2:
                    toppings.add(new PepperoniTopping());
                    System.out.println("Added Pepperoni topping.");
                    break;
                case 3:
                    toppings.add(new SquashTopping());
                    System.out.println("Added Squash topping.");
                    break;
                case 4:
                    toppings.add(new ZucchiniTopping());
                    System.out.println("Added Zucchini topping.");
                    break;
                case 5:
                    toppings.add(new PepperTopping());
                    System.out.println("Added Pepper topping.");
                    break;
                case 6:
                    toppings.add(new MozzarellaTopping());
                    System.out.println("Added Mozzarella topping.");
                    break;
                case 7:
                    toppings.add(new CheddarTopping());
                    System.out.println("Added Cheddar topping.");
                    break;
                case 8:
                    toppings.add(new ProvoloneTopping());
                    System.out.println("Added Provolone topping.");
                    break;
                case 9:
                    toppings.add(new HamTopping());
                    System.out.println("Added Ham topping.");
                    break;
                case 10:
                    toppings.add(new BaconTopping());
                    System.out.println("Added Bacon topping.");
                    break;
                case 11:
                    toppings.add(new TomatoTopping());
                    System.out.println("Added Tomato topping.");
                    break;
                case 12:
                    toppings.add(new HavartiTopping());
                    System.out.println("Added Havarti topping.");
                    break;
                case 13:
                    if (toppings.isEmpty()) {
                        System.out.println("You haven't selected any toppings yet!");
                    } else {
                        for (PizzaTopping topping : toppings) {
                            System.out.println(topping.toString());
                        }
                    }
                    break;
                default:
                    System.out.println("Incorrect input for topping.");
                    break;
            }

            if (userInput != 13) {
                toppingsCount += 1;
            }

            if (toppingsCount < 4) {
                System.out.println("Do you want to add more toppings? (up to 4)");
                System.out.print("""
                        - (y)
                        - (n)
                        """);

                validInput = false;
                while (!validInput) {
                    userInputString = input.nextLine().trim();

                    if (!userInputString.isEmpty()) {
                        char decision = userInputString.charAt(0);

                        switch (decision) {
                            case 'y':
                                validInput = true;
                                break;
                            case 'n':
                                moreToppings = false;
                                validInput = true;
                                break;
                            default:
                                System.out.println("Please enter yes/no only.");

                        }
                    } else {
                        System.out.println("Input cannot be empty, try again.");
                    }
                }
            } else {
                System.out.println("\nMaximum toppings reached.\n");
            }
        }

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
                System.out.println("\nSelected: Tomato Sauce\n");
                sauce = new TomatoSauce();
                break;
            case 2:
                System.out.println("\nSelected: Alfredo Sauce\n");
                sauce = new AlfredoSauce();
                break;
        }

        System.out.println("""
                What kind of crust would you like?
                1 - Thin Crust
                2 - Thick Cryst
                    """);
        validInput = false;

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
                System.out.println("\nSelected: Thin Crust\n");
                crust = new ThinCrust();
                break;
            case 2:
                System.out.println("\nSelected: Thick Crust\n");
                crust = new ThickCrust();
                break;
            default:
                System.out.println("\nInvalid option selected\n");
        }

        pizza = new Pizza(toppings, crust, sauce);
        pizza.getPizza();

    }
}
