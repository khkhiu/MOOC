/*
Here are the Business Rules that your solution must satisfy:

If the user is an Admin with a level greater than 55,  the message:
    Welcome, Super Admin user.

If the user is an Admin with a level less than or equal to 55,  the message:
    Welcome, Admin user.

If the user is a Manager with a level 20 or greater,  the message:
    Contact an Admin for access.

If the user is a Manager with a level less than 20,  the message:
    You do not have sufficient privileges.

If the user is not an Admin or a Manager,  the message:
    You do not have sufficient privileges.

Update your Program.cs code to accommodate each of the business rules.

*/
//string permission = "Admin";
string permission = "Manager";
int level = 20;

// for levels around 55
if (permission.Contains("Admin"))
{
    Console.WriteLine((level > 55 ? "Welcome, Super Admin user." : "Welcome, Admin user."));
}
else if (permission.Contains("Manager"))
{
    Console.WriteLine((level > 20 ? "Contact an Admin for access." : "You do not have sufficient privileges."));
}
else
{
    Console.WriteLine("You do not have sufficient privileges.");
}

