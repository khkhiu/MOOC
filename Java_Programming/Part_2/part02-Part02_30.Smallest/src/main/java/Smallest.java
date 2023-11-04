
public class Smallest {

    public static int smallest(int number1, int number2) {
        // Write some code here
        int small = 0;
        if (number1 > number2){
            small = number2;
        } else {
            small = number1;
        }
        return small;
    }

    public static void main(String[] args) {
        int result = smallest(2, 7);
        System.out.println("Smallest: " + result);
    }
}
