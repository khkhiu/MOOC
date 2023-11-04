
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Items> arrayListItems = new ArrayList();

        while (true) {
            // Prompt for identidying number
            System.out.println("Identifier? (empty will stop)");
            String identifyingNumber = scanner.nextLine();
            if (identifyingNumber.isEmpty()) {
                break;
            }
            // Prompt for name
            System.out.println("Name? (empty will stop)");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            // Adding new items to array
            Items item = new Items(name, identifyingNumber);

            // Prevent duplicate entry of items
            if (arrayListItems.contains(item)) {   
                System.out.println("Item already exsist in array");
            } else {
                arrayListItems.add(item);
            }
        }
        // Print out everything in array
        System.out.println("==Items==");
        for (Items i : arrayListItems) {
            System.out.println(i);
        }
    }
}