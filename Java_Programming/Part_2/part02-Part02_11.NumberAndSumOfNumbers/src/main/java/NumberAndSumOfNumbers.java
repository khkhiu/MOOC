
import java.util.Scanner;

public class NumberAndSumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * Write a program that asks the user for input until the user inputs 0. 
         * After this the program prints the amount of numbers inputted and the sum of the numbers. 
         * The number zero does not need to be added to the sum, but adding it does not change the results.
         */
        int total = 0;
        int inputsum = 0;

        while(true){
            System.out.println("Give a number:");
            Integer input = Integer.valueOf(scanner.nextLine());

            if (input != 0){
                total = input + total; 
                inputsum = inputsum + 1;
                continue;
            } else {
                System.out.println("Number of numbers: " + inputsum);
                System.out.println("Sum of the numbers: " + total);
                break;
            }
        }
    }
}
