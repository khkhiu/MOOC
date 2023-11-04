
import java.util.Scanner;

public class Story {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here

        // Prompt user for input
        System.out.println("I will tell you a story, but I need some information first.");
        System.out.println("What is the main character called?");

        // User enters name
        String name = scanner.nextLine();

        // Prompt user for 2nd input
        System.out.println("What is their job?");

        // User enters job
        String job = scanner.nextLine();

        // Create story
        System.out.println("Here is the story:");
        System.out.println("Once upon a time there was " + name + ", who was " + job + ".");
        System.out.println("On the way to work, " + name + " reflected on life.");
        System.out.println("Perhaps " + name + " will not be " + job + " forever.");   
    }
}
