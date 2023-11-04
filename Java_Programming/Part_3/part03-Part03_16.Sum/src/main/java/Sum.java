
import java.util.ArrayList;

public class Sum {

    public static void main(String[] args) {
        // Try your method here
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(6);
        numbers.add(-1);
        System.out.println(sum(numbers));

        numbers.add(5);
        numbers.add(1);
        System.out.println(sum(numbers));
    }

    public static int sum(ArrayList<Integer> numbers){
        int total = 0;
        // Using for each loop to loop through an array.
        // See here->https://www.w3schools.com/java/java_foreach_loop.asp
        for (int i : numbers){
            total = total + i;
        }
        return total;
    }

}
