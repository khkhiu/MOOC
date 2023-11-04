
import java.util.Scanner;

public class DifferentTypesOfInput {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Write your program here

        // Write your program here

        // prompt for string
        System.out.println("Give a string:");
        String text = scan.nextLine();

        // prompt for integer
        System.out.println("Give an integer:");
        int int_number = Integer.valueOf(scan.nextLine());

        // prompt for double
        System.out.println("Give a double:");
        double flt_number = Double.valueOf(scan.nextLine());

        // prompt for boolean
        System.out.println("Give a boolean:");
        boolean bin_number = Boolean.valueOf(scan.nextLine());

        // print output
        System.out.println("You gave the string " + text);
        System.out.println("You gave the integer " + int_number);
        System.out.println("You gave the double " + flt_number);
        System.out.println("You gave the boolean " + bin_number);
    }
}
