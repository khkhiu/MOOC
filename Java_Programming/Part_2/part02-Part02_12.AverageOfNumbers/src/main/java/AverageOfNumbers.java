
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * Write a program that asks the user for input until the user inputs 0. 
         * After this, the program prints the average of the numbers.
         * The number zero does not need to be counted to the average. You may assume that the user inputs at least one number.
         */
        double total = 0;
        int inputno = 0;
        double totalavg = 0;

        while(true){
            System.out.println("Give a number:");
            Integer input = Integer.valueOf(scanner.nextLine());

            if (input != 0){
                total = total + input;
                inputno = inputno + 1;
                totalavg = (total / inputno) / 1.0;
                continue;
            } else {
                System.out.println("Average of the numbers: " + totalavg);
                break;
            }
        }
    }
}
