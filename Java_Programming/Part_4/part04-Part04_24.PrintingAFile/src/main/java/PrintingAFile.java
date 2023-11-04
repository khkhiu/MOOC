
import java.nio.file.Paths;
import java.util.Scanner;

public class PrintingAFile {

    public static void main(String[] args) {
        // Create scanner to read "data.txt" file
        try (Scanner scanner = new Scanner(Paths.get("data.txt"))) {
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
