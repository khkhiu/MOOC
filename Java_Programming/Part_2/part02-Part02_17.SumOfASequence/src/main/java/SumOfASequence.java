
import java.util.Scanner;

public class SumOfASequence {

    //Implement a program, which calculates the sum 1+2+3+...+n 
    //where n is given as user input.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Last number?");
        Integer input = Integer.valueOf(scanner.nextLine());

        int sum = 0;

        for (int count = 0; count <= input; count++){
            sum = count + sum; 
        }
        System.out.println("The sum is " + sum);
    }
}
