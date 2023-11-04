
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {

        // Prompt for input
        Scanner scanner = new Scanner(System.in);
        System.out.println("file: ");
        String fileName = scanner.nextLine();
        System.out.println("Team: ");
        String searchForTeam = scanner.nextLine().toLowerCase();

        // INIT VAR for variables to be stored
        int gameCounter = 0;
        int wins = 0;
        int losses = 0;

        try ( Scanner fileScanner = new Scanner(Paths.get(fileName))) {
            while (fileScanner.hasNextLine()) {
                // Read info from 'file' and use arrays to store multiple values in a single VAR
                String[] splitString = fileScanner.nextLine().split(",");

                if (splitString.equals("")) {
                    continue;
                }

                // Assign entires of array, where arrays start with zero
                // Use 'trim' method to remove whitespaces from both sides of a string, reference:https://www.w3schools.com/java/ref_string_trim.asp
                String homeTeam = splitString[0].trim();
                String awayTeam = splitString[1].trim();
                // Convert String to Integer
                int homeTeamPoints = Integer.valueOf(splitString[2].trim());
                int awayTeamPoints = Integer.valueOf(splitString[3].trim());

                // Calculate points for team name enterred
                if (searchForTeam.equals(homeTeam.toLowerCase())) {
                    gameCounter++;
                    if (homeTeamPoints > awayTeamPoints) {
                        wins++;
                    } else {
                        losses++;
                    }
                }
                if (searchForTeam.equals(awayTeam.toLowerCase())) {
                    gameCounter++;
                    if (awayTeamPoints > homeTeamPoints) {
                        wins++;
                    } else {
                        losses++;
                    }
                }

            }
            // Print stats
            System.out.println("Games: " + gameCounter);
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);
        
            // See here for explanation for 'getMessage' method: https://www.geeksforgeeks.org/throwable-getmessage-method-in-java-with-examples/
        } catch (Exception e) {
            System.out.println("Error reading file" + e.getMessage());
        }

    }

}