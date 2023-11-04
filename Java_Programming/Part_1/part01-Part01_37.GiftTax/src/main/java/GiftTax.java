
import java.util.Scanner;

public class GiftTax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Prompt for input
        System.out.println("Value of the gift?");
        int gift = Integer.valueOf(scan.nextLine());
        
        if (gift < 5000) {
            System.out.println("No tax!");
        } else if (gift >=5000 && gift < 25000) {
            double value = gift - 5000;
            double tax = 100 + (value * 0.08);
            System.out.println("Tax: " + tax);
        } else if (gift >=25000 && gift < 55000) {
            double value = gift - 25000;
            double tax = 1700 + (value * 0.1);
            System.out.println("Tax: " + tax);
        } else if (gift >=55000 && gift < 200000) {
            double value = gift - 55000;
            double tax = 4700 + (value * 0.12);
            System.out.println("Tax: " + tax);
        } else if (gift >=200000 && gift < 1000000) {
            double value = gift - 200000;
            double tax = 22100 + (value * 0.15);
            System.out.println("Tax: " + tax);
        } else if (gift >= 1000000) {
            double value = gift - 1000000;
            double tax = 142100 + (value * 0.17);
            System.out.println("Tax: " + tax);
        }
    }
}
