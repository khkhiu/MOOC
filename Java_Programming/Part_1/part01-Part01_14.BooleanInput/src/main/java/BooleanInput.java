
import java.net.Socket;
import java.util.Scanner;

public class BooleanInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your program here
        // Prompt user for input
        System.out.println("Write something:");
        // Check for boolean variable
        boolean value = Boolean.valueOf(scanner.nextLine());
        // Print output
        System.out.println("True or false? " + value);

    }
}
