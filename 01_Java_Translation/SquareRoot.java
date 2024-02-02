import java.util.Scanner;
import java.lang.Math;

public class SquareRoot {
    public static void main(String[] args) {
        final float episilon = 0.00001F;
        float num;
        float guess = 1;
        Scanner inputScanner;
        

        System.out.print("Enter a number and I will guess its square root: ");
        inputScanner = new Scanner(System.in);

        num = inputScanner.nextFloat();

        while (Math.abs(guess * guess - num) > episilon) {
            guess = (guess + num/guess)/2;
        }
        
        String outputString = String.format("I guess the square root of %.2f is %.2f", num, guess);
        System.out.println(outputString);
    }
}