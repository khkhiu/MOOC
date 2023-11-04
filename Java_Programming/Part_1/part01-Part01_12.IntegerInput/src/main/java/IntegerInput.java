
import java.util.Scanner;

public class IntegerInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your program here
        // Prompt user for value
        System.out.println("Give a number:");
        // Accept user input
        int value = Integer.valueOf(scanner.nextLine());
        // Print value
        System.out.println("You gave the number " + value);
    }
}
