
public class MainProgram {

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        
        // Here you can write code to test that PaymentCard works as intended
        // be sure to erase the extra code for the last part of the exercise!
        
        /* OPS sequence
        Create Paul's card. The opening balance of the card is 20 euros
        Create Matt's card. The opening balance of the card is 30 euros
        Paul eats heartily
        Matt eats affordably
        The cards' values ​​are printed (each on its own line, with the cardholder name at the beginning of it)
        Paul tops up 20 euros
        Matt eats heartily
        The cards' values ​​are printed (each on its own line, with the cardholder name at the beginning of it)
        Paul eats affordably
        Paul eats affordably
        Matt tops up 50 euros
        The cards' values ​​are printed (each on its own line, with the cardholder name at the beginning of it)
         */
        PaymentCard paulsCard = new PaymentCard(20);
        PaymentCard mattsCard = new PaymentCard(30);

        paulsCard.eatHeartily();
        mattsCard.eatAffordably();
        System.out.println("Paul:" + paulsCard);
        System.out.println(" Matt: " + mattsCard);

        paulsCard.addMoney(20);
        mattsCard.eatHeartily();
        System.out.println("Paul:" + paulsCard);
        System.out.println(" Matt: " + mattsCard);
        
        paulsCard.eatAffordably();
        paulsCard.eatAffordably();
        mattsCard.addMoney(50);
        System.out.println("Paul:" + paulsCard);
        System.out.println(" Matt: " + mattsCard);
    }
}
