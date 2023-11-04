
import java.util.Scanner;

public class LastWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Using while loop to allow multi-line inputs
        while(true){
            // Reading user input
            String input = scanner.nextLine();

            // Split the 'input' string into an array of words using the space character as the delimiter
            String[] inputArraySplit = input.split(" ");

            // Print only the last item in index
            String lastItem = inputArraySplit[inputArraySplit.length-1];
            System.out.println(lastItem);

            // Stop running only if "enter" button is pressed without input
            if (input.equals("")){
                break;
            }
        }
    }
}
