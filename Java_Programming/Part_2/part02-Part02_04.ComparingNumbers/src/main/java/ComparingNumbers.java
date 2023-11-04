
import java.util.Scanner;

public class ComparingNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt for input
        int firstnum = Integer.valueOf(scanner.nextLine());
        int secondnum = Integer.valueOf(scanner.nextLine());

        if (firstnum > secondnum) {
            System.out.println(firstnum + " is greater than " + secondnum);
        } else if (firstnum < secondnum) {
            System.out.println(firstnum + " is smaller than " + secondnum);
        } else {
            System.out.println(firstnum + " is equal to " + secondnum);
        }

    }
}
