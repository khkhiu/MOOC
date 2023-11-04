

public class FromParameterToOne {

    public static void main(String[] args) {
        printFromNumberToOne(5);
    }
    public static void printFromNumberToOne(int number){
        for (int range = number; range > 0; range--){
            System.out.println(range);
        }
    }
}
