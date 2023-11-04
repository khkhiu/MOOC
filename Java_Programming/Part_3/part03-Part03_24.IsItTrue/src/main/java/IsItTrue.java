
import java.util.Scanner;

public class IsItTrue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.print("Give a string: ");
        String input = scanner.nextLine();
        // '==' cannot be used to compare strings
        if (input.equals("true")){
            System.out.println("You got it right!");
        } else {
            System.out.println("Try again!");
        }
    }
}
