
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
         * Write a program that asks the user for input until the user inputs 0. 
         * After this, the program prints the average of the positive numbers (numbers that are greater than zero).
         * If no positive number is inputted, the program prints "Cannot calculate the average"
         */
        double total = 0;
        int inputno = 0;
        double totalavg = 0;

        while(true){
            Integer input = Integer.valueOf(scanner.nextLine());

            if (input > 0){
                total = total + input;
                inputno = inputno + 1;
                totalavg = (total / inputno) / 1.0;
                continue;
            } else if (input < 0){
                continue;
            } else {
                if (inputno == 0){
                    System.out.println("Cannot calculate the average");
                    break;
                } else {
                    System.out.println(totalavg);
                    break;
                }
            } 
        }
    }
}
