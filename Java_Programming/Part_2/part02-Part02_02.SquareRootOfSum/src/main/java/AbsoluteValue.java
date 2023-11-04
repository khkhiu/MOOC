
import java.util.Scanner;

public class AbsoluteValue {
    public static void main(String[] main) {
        // Creating the scanner
        Scanner reader = new Scanner(System.in);

        // Prompt for input
        int val = Integer.valueOf(reader.nextLine());

        // if the number is less than 0, the program prints the given integer multiplied by -1
        if (val < 0) { 
            System.out.println(val * -1);
        } else { // otherwise print number itself
            System.out.println(val);
        }
    }
}
