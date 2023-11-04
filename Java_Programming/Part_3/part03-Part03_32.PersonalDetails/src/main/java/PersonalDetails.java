
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

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

        int totalAges = 0;
        int numberOfAges = 0;
        int longestName = inputName.get(0).length();
        int indexLocation = 0;

        // Code to find longest name and calculate average ages
        for (int i = 0; i < inputName.size(); i++){
            if (inputName.get(i).length() > longestName){
                longestName = inputName.get(i).length();
                indexLocation = i;
            }
            totalAges = totalAges + inputAge.get(i);
            numberOfAges = numberOfAges + 1;
        }
        double avgAge = 1.0 * totalAges / numberOfAges;
        System.out.println("Longest name: " + inputName.get(indexLocation));
        System.out.println("Avergae of the birth years: " + avgAge);

    }
}

