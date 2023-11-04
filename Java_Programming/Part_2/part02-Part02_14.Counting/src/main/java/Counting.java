
import java.util.Scanner;

public class Counting {

    /*
     * Write a program that reads an integer from the user.
     * Next, the program prints numbers from 0 to the number given by the user.
     * You can assume that the user always gives a positive number.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input = Integer.valueOf(scanner.nextLine());

        for (int count = 0; count <= input; count++){
            System.out.println(count);
        }
    }
}
