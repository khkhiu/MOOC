
import java.util.ArrayList;
import java.util.Scanner;

public class OnlyTheseNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == -1) {
                break;
            }

            numbers.add(number);
        }
        // Prompt for 1st and last number
        System.out.println("From where?");
        int inputstart = Integer.valueOf(scanner.nextLine());
        System.out.println("To where?");
        int inputend = Integer.valueOf(scanner.nextLine());

        while (inputstart <= inputend){
            System.out.println(numbers.get(inputstart));
            inputstart++;
        }
    }
}
