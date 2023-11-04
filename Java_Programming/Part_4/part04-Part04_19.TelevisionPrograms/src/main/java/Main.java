/* QUESTION
 * In the exercise template there is a ready-made class TelevisionProgram, representing a television program. The class has object variables name and duration, a constructor, and a few methods.
 * Implement a program that begins by reading television programs from the user. When the user inputs an empty string as the name of the program, the program stops reading programs.
 * After this the user is queried for a maximum duration. Once the maximum is given, the program proceeds to list all the programs whose duration is smaller or equal to the specified maximum duration.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // implement here your program that uses the TelevisionProgram class
        ArrayList<TelevisionProgram> programs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            // Prompt for input
            System.out.println("Name: ");
            String inputName = scanner.nextLine();
            // Break 'while' loop if user does not enter a name
            if (inputName.isEmpty()){
                break;
            }
            System.out.println("Duration: ");
            int inputDuration = Integer.valueOf(scanner.nextLine());

            //Add input to 'programs' array
            programs.add(new TelevisionProgram(inputName, inputDuration));
        }
        // Prompt for max duration
        System.out.println("Program's maximum duration?");
        int inputMaxDuration = Integer.valueOf(scanner.nextLine());

        // Use for each loop to print all programs with lower maximum duration than 'inputMaxDuration'
        for (TelevisionProgram i: programs){
            if(i.getDuration() <= inputMaxDuration){
                System.out.println(i.getName() + ", " + i.getDuration() + " minutes");
            }
        }
    }
}
