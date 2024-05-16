Exercise: Complete a challenge to extract, replace, and remove data from an input string
Completed 100 XP

Code challenges reinforce what you've learned and help you gain some confidence before continuing on.

In this challenge, you work with a string that contains a fragment of HTML. You extract data from the HTML fragment, replace some of its content, and remove other parts of its content to achieve the desired output.

If you're unfamiliar with HTML code, review the "Quick HTML primer" section at the end of this unit.
Extract, replace, and remove data from an input string

    Select and delete all code lines in the Visual Studio Code Editor.

    In Visual Studio Code, add the following "starter" code to get the data for the challenge:
    C# 

const string input = "<div><h2>Widgets &trade;</h2><span>5000</span></div>";

string quantity = "";
string output = "";

// Your work here

Console.WriteLine(quantity);
Console.WriteLine(output);

If you run the code the output displays blank lines, the starting values for quantity and output are empty string values.

Take a minute to review the first line of the code containing a string of HTML.
C#

const string input = "<div><h2>Widgets &trade;</h2><span>5000</span></div>";

Notice the tags:<div>,<h2>,<span> and symbol code &trade; contained in the input variable.

Examine the desired output for the final solution:
Output

Quantity: 5000
Output: <h2>Widgets &reg;</h2><span>5000</span>

Begin adding your solution code to the starter code under the comment // Your work here.

Set the quantity variable to the value by extracting the text from between the <span> and </span> tags.

Set the output variable to the value of input, then remove the <div> and </div> tags.

Replace the HTML character ™ (&trade;) with ® (&reg) in the output variable.

Run your solution and verify the output put matches the expected output.
Output

Quantity: 5000
Output: <h2>Widgets &reg;</h2><span>5000</span>