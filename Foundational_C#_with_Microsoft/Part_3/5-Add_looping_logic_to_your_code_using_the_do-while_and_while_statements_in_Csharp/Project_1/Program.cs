/*
Code project 1 - write code that validates integer input

Here are the conditions that your first coding project must implement:

    Your solution must include either a do-while or while iteration.

    Before the iteration block: your solution must use a Console.WriteLine() statement to prompt the user for an integer value between 5 and 10.

    Inside the iteration block:
        Your solution must use a Console.ReadLine() statement to obtain input from the user.
        Your solution must ensure that the input is a valid representation of an integer.
        If the integer value is not between 5 and 10, your code must use a Console.WriteLine() statement to prompt the user for an integer value between 5 and 10.
        Your solution must ensure that the integer value is between 5 and 10 before exiting the iteration.

    Below (after) the iteration code block: your solution must use a Console.WriteLine() statement to inform the user that their input value has been accepted.

    Run your application and verify that your code validates user input based on the specified requirements.

    For example, when you run your application, it should reject input values such as "two" and "2", but it should accept an input value of "7".

    The example described above, the console output should look similar to the following:
        Enter an integer value between 5 and 10
        two
        Sorry, you entered an invalid number, please try again
        2
        You entered 2. Please enter a number between 5 and 10.
        7
        Your input value (7) has been accepted.
*/

/*
string? readResult;
Console.WriteLine("Enter a string:");
do
{
    readResult = Console.ReadLine();
} while (readResult != null);

// capture user input in a string variable named readResult

int numericValue = 0;
bool validNumber = false;
// convert string to int
validNumber = int.TryParse(readResult, out numericValue);
*/

string? readResult;
string userInput = "";
int numValue = 0;
bool validnumRange = false;

Console.WriteLine("Enter an integer value between 5 and 10");

do
{
    // When using a Console.ReadLine() statement to obtain user input, 
    // it's common practice to use a nullable type string (designated string?) for the input variable and then evaluate the value entered by the user.
    readResult = Console.ReadLine();
    if (readResult != null)
    {
        userInput = readResult;
    }

    // The int.TryParse() method can be used to convert a string value to an integer.
    validnumRange = int.TryParse(userInput, out numValue);

    if (validnumRange == true)
    {
        if (numValue <=5 || numValue >= 10)
        {
            validnumRange = false;
            Console.WriteLine($"You entered ({numValue}). Please enter a number between 5 and 10.");
        }
    }
    else
    {
        Console.WriteLine("Sorry, you entered an invalid number, please try again");
    }
} while (validnumRange == false);

Console.WriteLine($"Your input value ({numValue}) has been accepted.");
Console.WriteLine("Press 'Enter' to terminate program");

readResult = Console.ReadLine();


