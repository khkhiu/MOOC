/*
Code project 2 - write code that validates string input

Here are the conditions that your second coding project must implement:

    Your solution must include either a do-while or while iteration.

    Before the iteration block: your solution must use a Console.WriteLine() statement to prompt the user for one of three role names: Administrator, Manager, or User.

    Inside the iteration block:
        Your solution must use a Console.ReadLine() statement to obtain input from the user.
        Your solution must ensure that the value entered matches one of the three role options.
        Your solution should use the Trim() method on the input value to ignore leading and training space characters.
        Your solution should use the ToLower() method on the input value to ignore case.
        If the value entered is not a match for one of the role options, your code must use a Console.WriteLine() statement to prompt the user for a valid entry.

    Below (after) the iteration code block: Your solution must use a Console.WriteLine() statement to inform the user that their input value has been accepted.

    The console output for this example should look similar to the following:

    Enter your role name (Administrator, Manager, or User)
    Admin
    The role name that you entered, "Admin" is not valid. Enter your role name (Administrator, Manager, or User)
    Administrator
    Your input value (Administrator) has been accepted.
*/

string? readResult;
string userRole = "";
bool validRole = false;

while (validRole == false)
{                
    Console.WriteLine("Enter your role name (Administrator, Manager, or User)");
    readResult = Console.ReadLine();
    if (readResult != null) 
    {
        userRole = readResult.Trim();
    }

    if (userRole.ToLower() == "administrator" || userRole.ToLower() == "manager" || userRole.ToLower() == "user") 
    {
        validRole = true;
    }
    else
    {
        Console.Write($"The role name that you entered, \"({userRole})\" is not valid. ");
    }

} 

Console.WriteLine($"Your input value ({userRole}) has been accepted.");
Console.WriteLine("Press 'Enter' to terminate program");
readResult = Console.ReadLine();
