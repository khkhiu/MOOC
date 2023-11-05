Code challenge: Add a method to display email addresses

In the code you start with, there are two arrays for internal and external employees. Remember, the domain for internal employees is "contoso.com" and the username for all employees is the first two characters of their first name, followed by their full last name.

Your challenge is to create a method that will display the email address of internal and external employees. The method should include an optional parameter for the domain name of external employees.

    Ensure that you have an empty Program.cs file open in Visual Studio Code.

    If necessary, open Visual Studio Code, and then complete the following steps to prepare a Program.cs file in the Editor:

        On the File menu, select Open Folder.

        Use the Open Folder dialog to navigate to, and then open, the CsharpProjects folder.

        In the Visual Studio Code EXPLORER panel, select Program.cs.

        On the Visual Studio Code Selection menu, select Select All, and then press the Delete key.

    Copy and paste the following code into the Visual Studio Code Editor.
    c# 

string[,] corporate = 
{
    {"Robert", "Bavin"}, {"Simon", "Bright"},
    {"Kim", "Sinclair"}, {"Aashrita", "Kamath"},
    {"Sarah", "Delucchi"}, {"Sinan", "Ali"}
};

string[,] external = 
{
    {"Vinnie", "Ashton"}, {"Cody", "Dysart"},
    {"Shay", "Lawrence"}, {"Daren", "Valdes"}
};

string externalDomain = "hayworth.com";

for (int i = 0; i < corporate.GetLength(0); i++) 
{
    // display internal email addresses
}

for (int i = 0; i < external.GetLength(0); i++) 
{
    // display external email addresses
}

Update the code to use a method to display the email addresses according to the challenge specifications.

Use what you've learned about using parameters and optional arguments to complete the update.

Verify that your code produces the following output:

robavin@contoso.com
sibright@contoso.com
kisinclair@contoso.com
aakamath@contoso.com
sadelucchi@contoso.com
siali@contoso.com
viashton@hayworth.com
codysart@hayworth.com
shlawrence@hayworth.com
davaldes@hayworth.com