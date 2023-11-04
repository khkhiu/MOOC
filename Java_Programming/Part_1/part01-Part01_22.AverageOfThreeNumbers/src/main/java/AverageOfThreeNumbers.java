
import java.util.Scanner;

public class AverageOfThreeNumbers {

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

        // Finding the average of both numbers
        // Use 2.0 to force decimal places
        double average_num = (first_num + second_num + third_num) / 3.0;
        System.out.println("The average is " + average_num);        

    }
}
