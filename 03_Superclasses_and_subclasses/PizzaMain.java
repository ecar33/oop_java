import toppings.PizzaTopping;
import toppings.meat_toppings.*;
import toppings.cheese_toppings.*;
import toppings.veggie_toppings.*;
import crusts.PizzaCrust;
import java.util.Scanner;

public class PizzaMain {
    public static void main(String[] args) {
        int userInput = 0;
        String userInputString = "";
        Scanner input = new Scanner(System.in);
        PizzaTopping topping;
        boolean MoreToppings = true;

        while (MoreToppings) {
            System.out.print("""
                    What kind of toppings would you like:
                        How many toppings?
                        1 - Sausage
                        2 - Pepperoni
                        3 - Green onions
                        4 - Olives
                        5 - Mozarella
                        6 - Parmesan
                    """);

            try {
                userInput = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            switch (userInput) {
                case 1:
                    topping = new SausageTopping();
                    System.out.println(topping.toString());
                    break;
                case 2:
                    topping = new PepperoniTopping();
                    System.out.println(topping.toString());
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Incorrect input for topping.");
            }

            System.out.println("Do you want to add more toppings?");
            System.out.println("""
                    - (y)
                    - (n)
                    """);
            
            userInputString = input.nextLine();

            switch (userInputString) {
                case "y":
                    System.out.println("Enter yes");
                    break;
                case "n":
                    MoreToppings = false;
                    System.out.println("Enter no");
                    break;
            }

            System.out.println("Done");
        }
    }
}
