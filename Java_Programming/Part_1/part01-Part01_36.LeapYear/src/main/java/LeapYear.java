
import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Prompt for input
        System.out.println("Give a year: ");
        int year = Integer.valueOf(scan.nextLine());
        
        // Used modulus FX to check if year is leap year
        // A year is a leap year if it is divisible by 4. However, if the year is divisible by 100, then it is a leap year only when it is also divisible by 400.
        int leapfour = year % 4;
        int leaphundred = year % 100;
        int leapfourhundred = year % 400;

        if (leaphundred == 0 && leapfourhundred == 0) {
            System.out.println("The year is a leap year.");
        } else if (leaphundred == 0 && leapfourhundred != 0) {
            System.out.println("The year is not a leap year.");
        } else if (leapfour == 0 ) {
            System.out.println("The year is a leap year.");
        } else {
            System.out.println("The year is not a leap year.");
        }

    }
}
