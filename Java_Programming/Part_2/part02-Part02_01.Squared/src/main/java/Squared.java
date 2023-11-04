
import java.util.Scanner;

public class Squared {
    public static void main(String[] main) {
        Scanner scanner = new Scanner(System.in);
        
        //Prompt for input
        int val = Integer.valueOf(scanner.nextLine());

        // Calculate the square value of the input
        int val2 = val * val;

        // Output sqaure of input value
        System.out.println(val2);

    }
}
