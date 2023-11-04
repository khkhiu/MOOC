
import java.nio.file.Paths;
import java.util.Scanner;

public class PrintingASpecifiedFile {

    public static void main(String[] args) {
        // Prompt for user input
        Scanner userScanner = new Scanner(System.in);
        System.out.println("Which file should have its contents printed?");
        String userInput = userScanner.nextLine();

        // Create scanner to read "data.txt" file
        try (Scanner scanner = new Scanner(Paths.get(userInput))) {
            // Use hasNextLine() method of Java Scanner class to check if there is another line in the input of this scanner.
            // Returns TRUE if it finds another line, otherwise returns FALSE.
            while (scanner.hasNextLine()) {
                // Read and print line that was read
                String row = scanner.nextLine();
                System.out.println(row);
            }
            // See here for execption handling: https://www.w3schools.com/java/java_try_catch.asp
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }        
    }
}
