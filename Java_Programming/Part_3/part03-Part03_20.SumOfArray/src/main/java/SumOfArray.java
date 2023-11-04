
public class SumOfArray {

    public static void main(String[] args) {
        // You can try the method here
        int[] array = {5, 1, 3, 4, 2};
        System.out.println(sumOfNumbersInArray(array));
    }

    public static int sumOfNumbersInArray(int[] array) {
        // Write some code here
        int sum = 0;
        //for-each loop. which is used exclusively to loop through elements in an array:
        for (int number: array){
            sum = sum + number;
        }
        return sum;
    }
}
