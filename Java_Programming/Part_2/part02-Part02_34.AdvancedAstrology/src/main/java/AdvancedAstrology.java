
public class AdvancedAstrology {

    public static void printStars(int number) {
        // part 1 of the exercise
        for (int i = 0; i < number; i++){
            System.out.print("*");
        }
        System.out.print("\n");
    }

    public static void printSpaces(int number) {
        // part 1 of the exercise
        for (int i = 0; i < number; i++){
            System.out.print(" ");
        }        
    }

    public static void printTriangle(int size) {
        // part 2 of the exercise
        for (int i = 1; i <= size; i++){
            printSpaces(size - i);
            printStars(i);
        }        
    }

    public static void christmasTree(int height) {
        // part 3 of the exercise
        int i = 1; //Counter for number of * in each row
        int j = height - 1; //Counter for number of spaces in each row
        while (i <= height * 2 && j >= 0) {
            printSpaces(j); //Print number of spaces for each row
            printStars(i); //Print number of * in each row
            i = i + 2; // Increment number of * for next row
            j--; // Decrease the number of spaces for each row
            
            // Printing the stump of the tree
            if (j == -1) {
                printSpaces(height - 2);
                System.out.println("***");
                printSpaces(height - 2);
                System.out.println("***");
            }
        }
    }

    public static void main(String[] args) {
        // The tests are not checking the main, so you can modify it freely.

        printTriangle(3);
        System.out.println("---");
        christmasTree(4);
        System.out.println("---");
        christmasTree(10);
    }
}
