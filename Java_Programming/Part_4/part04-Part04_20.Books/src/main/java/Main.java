/* QUESTION
 * Write a program that first reads book information from the user. The details to be asked for each book include the title, the number of pages and the publication year. Entering an empty string as the name of the book ends the reading process.
 * After this the user is asked for what is to be printed. If the user inputs "everything", all the details are printed: the book titles, the numbers of pages and the publication years. However, if the user enters the string "name", only the book titles are printed.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // implement here the program that allows the user to enter 
        // book information and to examine them
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            // Prompt for input
            System.out.println("Title: ");
            String inputTitle = scanner.nextLine();
            // Break 'while' loop if user does not enter a title
            if (inputTitle.isEmpty()){
                break;
            }
            System.out.println("Pages: ");
            int inputPages = Integer.valueOf(scanner.nextLine());
            System.out.println("Publication year: ");
            int inputPublicationYear = Integer.valueOf(scanner.nextLine());

            //Add input to 'programs' array
            books.add(new Book(inputTitle, inputPages, inputPublicationYear));
        }
        // Prompt for information to be printed
        System.out.println("What information will be printed?");
        String inputInfoToPrint = scanner.nextLine();

        // convert user input to lower case using 'toLowerCase()' Method
        // Print everything if user request everything
        if (inputInfoToPrint.toLowerCase().equals("everything")){
            for (Book i : books){
                System.out.println(i);
            }
        }
        // convert user input to lower case using 'toLowerCase()' Method
        // Print title if user request name
        if (inputInfoToPrint.toLowerCase().equals("name")||inputInfoToPrint.toLowerCase().equals("title")){
            for (Book i : books){
                System.out.println(i.getTitle());
            }
        }
    }
}
