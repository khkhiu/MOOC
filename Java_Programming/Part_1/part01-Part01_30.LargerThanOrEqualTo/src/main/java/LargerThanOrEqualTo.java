
import java.util.Scanner;

public class LargerThanOrEqualTo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Write your program here
        // Prompt for input
        System.out.println("Give the first number:");
        int firstnum = Integer.valueOf(scan.nextLine());
        System.out.println("Give the second number:");
        int secondnum = Integer.valueOf(scan.nextLine());

        if (firstnum > secondnum) {
            System.out.println("Greater number is: " + firstnum);
        } else if (firstnum < secondnum) {
            System.out.println("Greater number is: " + secondnum);
        } else {
            System.out.println("The numbers are equal!");
        }
    }
}
