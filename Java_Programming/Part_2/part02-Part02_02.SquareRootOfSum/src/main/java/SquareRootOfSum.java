
import java.util.Scanner;

public class SquareRootOfSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Prompt for 2 input
        int val1 = Integer.valueOf(scanner.nextLine());
        int val2 = Integer.valueOf(scanner.nextLine());

        // Calculate the square root of the sum of both the input
        double sum = Math.sqrt(val1 + val2);

        // Output sqaure of input value
        System.out.println(sum);

    }
}
