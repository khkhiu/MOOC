
import java.util.Scanner;

public class CheckingTheAge {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt for input
        System.out.println("How old are you? ");
        int age = Integer.valueOf(scan.nextLine());

        // Use 'and' operator to check age
        if (age >= 0 && age <= 120) {
            System.out.println("OK");
        } else {
            System.out.println("Impossible!");
        }
    }
}
