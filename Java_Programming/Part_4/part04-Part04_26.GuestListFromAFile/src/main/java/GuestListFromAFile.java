
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class GuestListFromAFile {

    public static void main(String[] args) {

        // Prompt user for name of file to read
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the file:");
        String file = scanner.nextLine();

        // Array to contain list of names
        ArrayList<String> list = new ArrayList<>();

        // implement reading the file here.
        try (Scanner fileScanner = new Scanner(Paths.get(file))) {
            // Use hasNextLine() method of Java Scanner class to check if there is another line in the input of this scanner.
            // Returns TRUE if it finds another line, otherwise returns FALSE.
            while (fileScanner.hasNextLine()) {
                // Read and add content of file to array 'list'
                String row = fileScanner.nextLine();
                list.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }    

        // Prompt for name to check against 'list'
        System.out.println("Enter names, an empty line quits.");
        // Exit program if user press 'enter'
        while (true) {
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }

            if (list.contains(name)) {
                System.out.println("The name is on the list.");
            } else {
                System.out.println("The name is not on the list.");
            }
        }
        System.out.println("Thank you!");
    }
}
