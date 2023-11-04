
import java.util.Scanner;

public class Conversation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        // Prompt user for first input
        System.out.println("Greetings! How are you doing?");
        // 'nextLine' contines exe aftter next line is complete
        String First_Response = scanner.nextLine();
        // Prompt user for second input
        System.out.println("Oh, how interesting. Tell me more!");
        // Wait for second response
        String Second_Response = scanner.nextLine();
        // Final line
        System.out.println("Thanks for sharing!");
    }
}
