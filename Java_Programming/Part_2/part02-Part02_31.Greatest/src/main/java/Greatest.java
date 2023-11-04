
public class Greatest {

    public static int greatest(int number1, int number2, int number3) {
        //write some code here
        int largest = 0;
        largest = Math.max(number1, Math.max(number2, number3));
        return largest;
    }

    public static void main(String[] args) {
        int result = greatest(2, 7, 3);
        System.out.println("Greatest: " + result);
    }
}
