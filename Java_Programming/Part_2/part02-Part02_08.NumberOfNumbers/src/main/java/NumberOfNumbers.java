
import java.util.Scanner;

public class NumberOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputnum = 0;

        while(true){
            System.out.println("Give a number:");
            Integer input = Integer.valueOf(scanner.nextLine());

            if (input != 0){
                inputnum = inputnum + 1; 
                continue;
            } else {
                System.out.println("Number of numbers: " + inputnum);
                break;
            }
        }

    }
}
