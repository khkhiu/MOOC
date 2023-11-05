Exercise - Complete a challenge to combine string array values as strings and as integers
Completed 100 XP

Code challenges reinforce what you've learned and help you gain some confidence before continuing.

This module features two code challenges. This first challenge forces you to split up the data depending on its type and either concatenate or add the data accordingly.

    Select and delete all code lines in the Visual Studio Code Editor. Optionally, use the line comment operator // to comment out all of the code from the previous step.

    To instantiate a string array, enter the following "starter" code:
    C# 

string[] values = { "12.3", "45", "ABC", "11", "DEF" };

Create a looping structure that can be used to iterate through each string value in the array values.

Complete the required code, placing it within the array looping structure code block. It's necessary to implement the following business rules in your code logic:

    Rule 1: If the value is alphabetical, concatenate it to form a message.

    Rule 2: If the value is numeric, add it to the total.

    Rule 3: The result should match the following output:
    Output 

    Message: ABCDEF
    Total: 68.3

Once your code is complete, in the Visual Studio Code File menu, select Save.

The Program.cs file must be saved before building or running the code.

In the EXPLORER panel, to open a Terminal at your TestProject folder location, right-click TestProject, and then select Open in Integrated Terminal.

A Terminal panel should open, and should include a command prompt showing that the Terminal is open to your TestProject folder location.

At the Terminal command prompt, to run your code, type dotnet run and then press Enter.

You should see the following output:
Output

    Message: ABCDEF
    Total: 68.3
