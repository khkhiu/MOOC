
import java.util.Scanner;

public class SumOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here

        // Prompt for first number
        System.out.println("Give the first number:");
        int first_num = Integer.valueOf(scanner.nextLine());

        // Prompt for second number
        System.out.println("Give the second number:");
        int second_num = Integer.valueOf(scanner.nextLine());

        // Prompt for third number
        System.out.println("Give the third number:");
        int third_num = Integer.valueOf(scanner.nextLine());

        // summing and displaying numbers
        int total = first_num + second_num + third_num;
        System.out.println("The sum of the numbers is " + total);

    }
}
