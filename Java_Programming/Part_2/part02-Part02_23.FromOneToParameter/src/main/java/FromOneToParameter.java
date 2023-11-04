

public class FromOneToParameter {

    public static void main(String[] args) {
        printUntilNumber(5);
    }
    public static void printUntilNumber(int number){
        for (int range = 1; range <= number; range++){
            System.out.println(range);
        }
    }
}
