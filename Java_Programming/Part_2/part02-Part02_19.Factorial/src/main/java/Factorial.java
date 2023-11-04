
import java.util.Scanner;

public class Factorial {

    /*
     * Implement a program which calculates the factorial of a number given by the user.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give a number:");
        Integer input = Integer.valueOf(scanner.nextLine());

        int sum = 1;

        for (int count = 1; count <= input; count++){
            sum = count * sum; 
        }
        System.out.println("Factorial: " + sum);
    }
}
