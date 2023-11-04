/* QUESTION
 * The program described here should be implemented in the class PersonalInformationCollection. 
 * Do not modify the class PersonalInformation.
 * After the user has entered the last set of details (they enter an empty first name), exit the repeat statement.
 * Then print the collected personal information so that each entered object is printed in the following format: 
 * first and last names separated by a space (you don't print the identification number).
 */

import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        // implement here your program that uses the PersonalInformation class

        ArrayList<PersonalInformation> infoCollection = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Prompt for input
            System.out.println("First name: ");
            String userFirstName = scanner.nextLine();
            // Break 'while' loop if user does not enter a first name
            if (userFirstName.isEmpty()){
                break;
            }
            System.out.println("Last name: ");
            String userLastName = scanner.nextLine();

            System.out.println("identification number: ");
            String userIdNumber = scanner.nextLine();

            // Add user inputted information to list in 'PersonalInformation' class
            infoCollection.add(new PersonalInformation(userFirstName, userLastName, userIdNumber));
        }
        // Use 'for each' loop to print user inputed first and last name from the 'PersonalInformation' class
        // a "for-each" loop, which is used exclusively to loop through elements in an array:
        // See here: https://www.w3schools.com/java/java_foreach_loop.asp
        for (PersonalInformation i : infoCollection){
            System.out.println(i.getFirstName() + " " + i.getLastName());
        }
    }
}
