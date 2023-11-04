
import java.nio.file.Paths;
import java.util.Scanner;

public class RecordsFromAFile {

    public static void main(String[] args) {
        // Prompt for file name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the file:");
        String file = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(Paths.get(file))) {
            while (fileScanner.hasNextLine()) {
                // Read info from 'file' and use arrays to store multiple values in a single VAR
               String[] splitString = fileScanner.nextLine().split(",");

               if(splitString.equals("")){
                continue;
               }
               // Assign first entry of array as name, where arrays start with zero
               String name = splitString[0];
               // Assign 2nd entry or array as age, where arrays stars with zero
               int age = Integer.valueOf(splitString[1]);

               if (age > 1 || age == 0){
                // If age is more than 1, use 'years'
                System.out.println(name + ", age: " + age + " years");
               } else {
                System.out.println(name + ", age: " + age + " year");
               }

            }
        } catch (Exception e){
            System.out.println("Reading the file " + file + " failed.");
        }
    }
}
