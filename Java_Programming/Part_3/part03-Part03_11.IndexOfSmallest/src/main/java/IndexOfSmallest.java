
import java.util.ArrayList;
import java.util.Scanner;

public class IndexOfSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // implement here a program that reads user input
        // until the user enters 9999
        
        // after that, the program prints the smallest number
        // and its index -- the smallest number
        // might appear multiple times
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == 9999) {
                break;
            }

            list.add(input);
        }

        int smallestnumber = list.get(0);

        // Code to identify smallest number
        for(int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            if (smallestnumber > number) {
                smallestnumber = number;
            }
        }
        System.out.println("Smallest number: " + smallestnumber);
        // Code to find location
        for (int i = 0; i < list.size(); i++){
            if(list.get(i) == smallestnumber){
                System.out.println("Found at index: " + i);   
            }
        }
    }
}
