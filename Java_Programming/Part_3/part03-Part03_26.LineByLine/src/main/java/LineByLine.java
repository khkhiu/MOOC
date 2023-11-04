
import java.util.Scanner;

public class LineByLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Using while loop to allow multi-line inputs
        while(true){
            // Reading user input
            String input = scanner.nextLine();

            // Split the 'input' string into an array of words using the space character as the delimiter
            String[] inputArraySplit = input.split(" ");

            // Iterate over each word in the 'inputArraySplit' array
            for (int i = 0; i < inputArraySplit.length; i++){
                // Print the current word on a separate line
                System.out.println(inputArraySplit[i]);
                }
            // Stop running only if "enter" is pressed without an input
            if (input.equals("")){
                break;
            }
        }
    }
}
