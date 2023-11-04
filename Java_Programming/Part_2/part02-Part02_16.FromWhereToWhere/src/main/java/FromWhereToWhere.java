
import java.util.Scanner;

public class FromWhereToWhere {

    /*Write a program which prints the integers from 1 to a number given by the user.
     *Ask the user for the starting point as well.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt for end point
        System.out.println("Where to?");
        Integer endinput = Integer.valueOf(scanner.nextLine());
        // Prompt for start point
        System.out.println("Where from?");
        Integer startinput = Integer.valueOf(scanner.nextLine());

        for (int range = startinput; range <= endinput; range++){ 
            System.out.println(range);
        }
    }
}
