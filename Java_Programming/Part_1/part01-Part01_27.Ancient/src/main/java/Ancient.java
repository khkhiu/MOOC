
import java.util.Scanner;

public class Ancient {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Write your program here
        // Prompt for response
        System.out.println("Give a year:");
        int num = Integer.valueOf(scan.nextLine());

        if (num < 2015) {
            System.out.println("Ancient history!");
        }              
    }
}
