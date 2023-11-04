
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        // Prompt for first number
        System.out.println("Give the first number:");
        int first_num = Integer.valueOf(scanner.nextLine());

        // Prompt for second number
        System.out.println("Give the second number:");
        int second_num = Integer.valueOf(scanner.nextLine());

        // Calculator operations
        int total = first_num + second_num;
        System.out.println(first_num + " + " + second_num + " = " + total);  
        int subtract = first_num - second_num;
        System.out.println(first_num + " - " + second_num + " = " + subtract);  
        int multi = first_num * second_num;
        System.out.println(first_num + " * " + second_num + " = " + multi);  
        // divide by 1.0 to force decimal places
        double div = (first_num / 1.0) / (second_num / 1.0);
        System.out.println(first_num + " / " + second_num + " = " + div);  
    }
}
