
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Storing usernames as array
        String[] usernameArray = {"alex", "emma"};
        // Storing passwords as array
        String[] passwordArray = {"sunshine", "haskell"};

        // Prompt for username and password
        System.out.print("Enter username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Enter password: ");
        String passwordInput = scanner.nextLine();

        // Using boolean to check for mathc
        boolean match = false;

        // Check if input length match username length, if lengths don't match, username is incorrect
        for (int i = 0; i <usernameArray.length; i++){
            // Check if strings match for both username and password
            if(usernameArray[i].equals(usernameInput) && passwordArray[i].equals(passwordInput)){
                // Set 'match' to true if match found
                match = true;
            }
        }

        if(match){
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("Incorrect username or password!");
        }
    }
}
