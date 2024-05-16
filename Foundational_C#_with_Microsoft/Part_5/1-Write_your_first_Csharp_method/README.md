Code challenge: create a reusable method

In the code that you start with, there's a generic text array, followed by good, bad, and neutral text arrays. Depending on the value of luck, one of the arrays is selected and displayed alongside the generic text.

Your challenge is to create a reusable method that prints a player's fortune at any time. The method should contain the logic that is already present in the code provided.

    Ensure that you have an empty Program.cs file open in Visual Studio Code.

    If necessary, open Visual Studio Code, and then complete the following steps to prepare a Program.cs file in the Editor:

        On the File menu, select Open Folder.

        Use the Open Folder dialog to navigate to, and then open, the CsharpProjects folder.

        In the Visual Studio Code EXPLORER panel, select Program.cs.

        On the Visual Studio Code Selection menu, select Select All, and then press the Delete key.

    Copy and paste the following code into the Editor:
    c# 

Random random = new Random();
int luck = random.Next(100);

string[] text = {"You have much to", "Today is a day to", "Whatever work you do", "This is an ideal time to"};
string[] good = {"look forward to.", "try new things!", "is likely to succeed.", "accomplish your dreams!"};
string[] bad = {"fear.", "avoid major decisions.", "may have unexpected outcomes.", "re-evaluate your life."};
string[] neutral = {"appreciate.", "enjoy time with friends.", "should align with your values.", "get in tune with nature."};

Console.WriteLine("A fortune teller whispers the following words:");
string[] fortune = (luck > 75 ? good : (luck < 25 ? bad : neutral));
for (int i = 0; i < 4; i++) 
{
    Console.Write($"{text[i]} {fortune[i]} ");
}

Update the code to use a method to display the fortune.

Use what you've learned about creating and calling methods to complete the update.

Test your code by changing the value of luck and calling the method again.

Verify that your code produces one of the following messages:
Output

A fortune teller whispers the following words:
You have much to look forward to. Today is a day to try new things! Whatever work you do is likely to succeed. This is an ideal time to accomplish your dreams! 

Output

A fortune teller whispers the following words:
You have much to appreciate. Today is a day to enjoy time with friends. Whatever work you do should align with your values. This is an ideal time to get in tune with nature. 

Output

A fortune teller whispers the following words:
You have much to fear. Today is a day to avoid major decisions. Whatever work you do may have unexpected outcomes. This is an ideal time to re-evaluate your life.
