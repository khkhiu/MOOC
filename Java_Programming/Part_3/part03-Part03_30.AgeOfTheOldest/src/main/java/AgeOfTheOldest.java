
import java.util.ArrayList;
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Using ArrayList class, a resizable array
        // See here->https://www.w3schools.com/java/java_arraylist.asp
        ArrayList<String> inputName = new ArrayList<String>();
        ArrayList<Integer> inputAge = new ArrayList<Integer>();

        // Using while loop to allow multi-line inputs
        while(true){
            // Reading user input
            String input = scanner.nextLine();

            if (input.length() > 0){
                // Split the 'input' string into an array of words using the comma character as the delimiter
                String[] inputArraySplit = input.split(",");

                inputName.add(inputArraySplit[0]);
                // Using "Integer.parseInt" to add entry as an integer
                inputAge.add(Integer.parseInt(inputArraySplit[1]));
            }

            // Stop running only if "enter" button is pressed without input
            if (input.equals("")){
                break;
            }
        }
        // Code to compare ages
        int oldestAge = inputAge.get(0);
        for (int i = 0; i < inputAge.size(); i++){
            int highestAge = inputAge.get(i);
            if (oldestAge < highestAge){
                oldestAge = inputAge.get(i);
            }
        }
        System.out.println("Age of the oldest: " + oldestAge);
    }
}
