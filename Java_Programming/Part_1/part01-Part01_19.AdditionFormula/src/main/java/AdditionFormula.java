
import java.util.Scanner;

public class AdditionFormula {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your program here

        // Prompt for first number
        System.out.println("Give the first number:");
        int first_num = Integer.valueOf(scanner.nextLine());

        // Prompt for second number
        System.out.println("Give the second number:");
        int second_num = Integer.valueOf(scanner.nextLine());

        // summing and displaying both numbers
        int total = first_num + second_num;
        System.out.println(first_num + " + " + second_num + " = " + total);

    }
}
