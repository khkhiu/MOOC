
import java.util.Scanner;

public class DoubleInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your program here
        // Prompt user for input
        System.out.println("Give a number:");
        // Accept user input
        double value =  Double.valueOf(scanner.nextLine());
        // Print output
        System.out.println("You gave the number " + value);

    }
}
