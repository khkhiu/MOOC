
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    /*
     * Implement a program which calculates the sum of a closed interval, and prints it.
     *  Expect the user to write the smaller number first and then the larger number.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt for start point
        System.out.println("Last number?");
        Integer startinput = Integer.valueOf(scanner.nextLine());
        // Prompt for end point
        System.out.println("First number?");
        Integer endinput = Integer.valueOf(scanner.nextLine());

        // Adding sum between both numbers
        int sum = 0;
        for (int range = startinput; range <= endinput; range++){ 
            sum = sum + range;
        }
        System.out.println("The sum is " + sum);
    }
}
