
import java.nio.file.Paths;
import java.util.Scanner;

public class IsItInTheFile {

    public static void main(String[] args) {
        // Prompt for name of file, then prompt for name to search for
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the file:");
        String file = scanner.nextLine();

        System.out.println("Search for:");
        String searchedFor = scanner.nextLine();

        // use boolean to to determine if requested item is found
        boolean itemFound = false;

        // See her for 'try-catch' syntax:https://www.w3schools.com/java/java_try_catch.asp
        try (Scanner fileScanner = new Scanner(Paths.get(file))){
            while (fileScanner.hasNextLine()){
                String row = fileScanner.nextLine();

                if (searchedFor.equals(row)){
                    // toggle boolean 'itemFound' to true if requested item is found
                    itemFound = true;
                }
            }
            if (itemFound == true){
                System.out.println("Found!");
            } else {
                System.out.println("Not found.");
            }
        } catch (Exception e){
            System.out.println("Reading the file " + file + " failed.");
        }
    }
}
