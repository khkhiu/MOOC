
import java.util.Scanner;

public class AreWeThereYet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Looping prompt until user enters '4'
        while (true) {
            System.out.println("Give a number:");
            String input = scanner.nextLine();
            if (input.equals("4")) {
                break;
            }
        }

    }
}
