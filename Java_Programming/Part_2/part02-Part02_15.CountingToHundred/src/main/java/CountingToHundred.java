
import java.util.Scanner;

public class CountingToHundred {
    /*Write a program, which reads an integer from the user. 
     *Then the program prints numbers from that number to 100. 
     *You can assume that the user always gives a number less than 100. 
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input = Integer.valueOf(scanner.nextLine());

        for (int count = input; count <= 100; count++){
            System.out.println(count);
        }
    }
}
