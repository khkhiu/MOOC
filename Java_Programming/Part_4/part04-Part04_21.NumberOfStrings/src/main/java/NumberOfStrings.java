/*
 * Write a program that reads strings from the user until the user inputs the string "end". At that point, the program should print how many strings have been read. The string "end" should not be included in the number strings read. You can find some examples below of how the program works.
 */
import java.util.Scanner;

public class NumberOfStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Var to count number of words enterred
        int count = 0;
        
        while (true){
            String line = scanner.nextLine();
            // Ends loop if user enters "end"
            if (line.toLowerCase().equals("end")){
                break;
            }
            // Increment count if user does NOT enter "end"
            count = count + 1;
        }
        // Print count after loop has ended
        System.out.println(count);
    }
}
