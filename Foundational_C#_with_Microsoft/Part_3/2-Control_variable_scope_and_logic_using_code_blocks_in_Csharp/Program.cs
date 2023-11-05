/*
Type the following code into the Visual Studio Code Editor:

using System;

int[] numbers = { 4, 8, 15, 16, 23, 42 };

foreach (int number in numbers)
{
    int total;

    total += number;

    if (number == 42)
    {
       bool found = true;

    }

}

if (found) 
{
    Console.WriteLine("Set contains 42");

}

Console.WriteLine($"Total: {total}");

Review the intended output.
When you have completed the required code edits, your application should produce the following output:
Output

Set contains 42
Total: 108

Complete the code updates required so that the existing Console.WriteLine() statements produce the desired output.

Variable scope may need to be adjusted.

*/
using System;

int[] numbers = { 4, 8, 15, 16, 23, 42 };
int total = 0;
bool found = false;

foreach (int number in numbers)
{
    total += number;

    if (number == 42)
    {
       found = true;
    }
    if (found == true)
    {
        Console.WriteLine("Set contains 42");
        Console.WriteLine($"Total: {total}");
    }
}
