/*
 * Write a program that reads strings from the user until the user inputs the string "end". As long as the input is not "end", the program should handle the input as an integer and print the cube of the number provided (i.e., number _ number _ number). Below are some sample outputs
 */
import java.util.Scanner;
// Import module for math OPS
import java.lang.Math;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int cube = 3;
        int inputNum = 0;

        while (true){
            String input = scanner.nextLine();
            // Ends loop if user enters "end"
            if (input.toLowerCase().equals("end")){
                break;
            } else {
                inputNum = Integer.parseInt(input);
            }
            // See here for Math ops: https://www.geeksforgeeks.org/math-pow-method-in-java-with-example/
            int outDecimal = (int)Math.pow(inputNum, cube);
            System.out.println(outDecimal);
        }

    }
}
