
import java.util.Scanner;

public class SumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * Write a program that reads values from the user until they input a 0. 
         * After this, the program prints the total number of inputted values that are negative. 
         * The zero that's used to exit the loop should not be included in the total number count.
         */
        int total = 0;

        while(true){
            System.out.println("Give a number:");
            Integer input = Integer.valueOf(scanner.nextLine());

            if (input != 0){
                total = input + total; 
                continue;
            } else {
                System.out.println("Sum of the numbers: " + total);
                break;
            }
        }
    }
}
