
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        // You can test your program here

        // Code provided by question
        // Timer is printed and it advances every milisecond
        Timer timer = new Timer();

        while (true) {
            System.out.println(timer);
            timer.advance();

            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }
    }
}
