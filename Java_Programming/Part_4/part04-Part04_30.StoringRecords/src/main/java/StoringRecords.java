
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class StoringRecords {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Filename:");
        String file = scan.nextLine();

        ArrayList<Person> records = readRecordsFromFile(file);
        System.out.println("Persons: " + records.size());
        System.out.println("Persons:");
        for (Person person : records) {
            System.out.println(person);

        }
    }

    public static ArrayList<Person> readRecordsFromFile(String file) {
        ArrayList<Person> persons = new ArrayList<>();

        // Write here the code for reading from file
        // and printing the read records
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

               // Call 'Person' class to add new name and age
               persons.add(new Person(name, age));

            }
        // See here for explanation for 'getMessage' method: https://www.geeksforgeeks.org/throwable-getmessage-method-in-java-with-examples/
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return persons;
    }
}
