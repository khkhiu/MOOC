
import java.nio.file.Paths;
import java.util.Scanner;

public class NumbersFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompting user for input
        System.out.print("File? ");
        String file = scanner.nextLine();
        System.out.print("Lower bound? ");
        int lowerBound = Integer.valueOf(scanner.nextLine());
        System.out.print("Upper bound? ");
        int upperBound = Integer.valueOf(scanner.nextLine());

        // VAR to track number of numbers fall within given range
        int count = 0;

        try(Scanner fileScanner = new Scanner(Paths.get(file))){
            // EXE code if next line is detected
            while(fileScanner.hasNextLine()){
                // Convert user input from string to integer
                int row = Integer.valueOf(fileScanner.nextLine());
                // Increment count if number within given range is detected
                if(row >= lowerBound && row <= upperBound){
                    count++;
                }
            }
            System.out.println("Numbers: " + count);
            
        } catch (Exception e){
            System.out.println("File not found" + e.getMessage());
        }
    }

}
