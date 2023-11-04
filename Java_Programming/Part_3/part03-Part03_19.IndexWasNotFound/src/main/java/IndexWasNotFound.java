

import java.util.Scanner;

public class IndexWasNotFound {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        array[0] = 6;
        array[1] = 2;
        array[2] = 8;
        array[3] = 1;
        array[4] = 3;
        array[5] = 0;
        array[6] = 9;
        array[7] = 7;

        System.out.print("Search for? ");
        int searching = Integer.valueOf(scanner.nextLine());

        boolean match = false;
        int index = 0;

        // Implement the search functionality here
        for (int i = 0; i < array.length; i++){
            if(array[i] == searching){
                // if array and user input match, assign 'match' as ture and assign index location
                match = true;
                index = i;
                break;
            }
        }
        // if array and user input match, print
        if(match){
            System.out.println(searching + " is at index " + index + ".");
        } else { // Otherwise print
            System.out.println(searching + " was not found.");
        }        
    }
}
