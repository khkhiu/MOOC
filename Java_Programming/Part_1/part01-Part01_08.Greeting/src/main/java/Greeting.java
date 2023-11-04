
import java.util.Scanner;

public class Greeting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here

        // Prompt user for name
        System.out.println("What's your name?");

        // User enters name
        String user_name = scanner.nextLine();
        
        // Greet user
        System.out.println("Hi " + user_name);
    }
}
