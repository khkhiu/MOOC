
import java.util.Scanner;

public class MessageThreeTimes {

    public static void main(String[] args) {
        // Use Scanner to read strings 
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write a message:");
        // Write your program here

        // Accept user input
        String message = scanner.nextLine();

        // Print input 3 times
        System.out.println(message);
        System.out.println(message);
        System.out.println(message);
    }
}
