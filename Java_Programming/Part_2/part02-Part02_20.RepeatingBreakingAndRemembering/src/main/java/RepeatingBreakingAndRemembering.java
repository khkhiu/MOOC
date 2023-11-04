
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {
        
        // This exercise is worth five exercise points, and it is 
        // gradually extended part by part.
        
        // If you want, you can send this exercise to the server
        // when it's just partially done. In that case the server will complain about 
        // the parts you haven't done, but you'll get points for the finished parts.
        
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int inputno = 0;
        double sumfl = 0;
        double inputavg = 0;
        int inputeven = 0;
        int inputodd = 0;

        System.out.println("Give numbers");
        Integer input = Integer.valueOf(scanner.nextLine());
        
        while (input != -1){
            sum = sum + input;
            sumfl = sumfl + input;
            inputno = inputno + 1;
            inputavg = sumfl / inputno;

            if (input % 2 == 0){
                inputeven++;
            } else {
                inputodd++;
            }

            input = Integer.valueOf(scanner.nextLine());
        }
        System.out.println("Thx! Bye!");
        System.out.println("Sum: " + sum);
        System.out.println("Numbers: " + inputno);
        System.out.println("Average: " + inputavg);
        System.out.println("Even: " + inputeven);
        System.out.println("Odd: " + inputodd);
    }
}
