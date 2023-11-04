
public class YourFirstBankTransfer {

    public static void main(String[] args) {
        // Do not touch the code in Account.java
        // write your program here
        // Create accounts
        Account matthewAccount = new Account("Matthews account", 1000);
        Account myAccount = new Account("My account", 0);

        // Account OPS
        matthewAccount.withdrawal(100);
        myAccount.deposit(100);

        // Print
        System.out.println(matthewAccount);
        System.out.println(myAccount);
    }
}
