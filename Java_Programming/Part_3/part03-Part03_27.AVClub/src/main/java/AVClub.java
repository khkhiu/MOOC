
import java.util.Scanner;

public class AVClub {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Using while loop to allow multi-line inputs
        while(true){
            // Reading user input
            String input = scanner.nextLine();

            // Split the 'input' string into an array of words using the space character as the delimiter
            String[] inputArraySplit = input.split(" ");

            // Using for-each loop to iterate through array
            for (String i:inputArraySplit){
                if(i.contains("av")){
                    System.out.println(i);
                }
            }
            // Stop running only if "enter" button is pressed without input
            if (input.equals("")){
                break;
            }
        }
    }
}
