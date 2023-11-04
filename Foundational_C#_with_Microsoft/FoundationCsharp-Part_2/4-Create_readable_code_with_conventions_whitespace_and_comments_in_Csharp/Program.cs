/* 
In this challenge, you'll use the techniques you learned in this module to improve the readability of a code sample. 
You are provided with a code sample that is poorly styled and commented. 
Your goal is to update the code using style guidelines for variable names, code comments, and whitespace to improve code readability.
*/


/*
CODE OPS:
   1. The code reverses a message
   2. Counts the number of times a particular character appears
   3. Then prints the results to the console window.
 */

// Original Message in question
string originalMessage = "The quick brown fox jumps over the lazy dog.";
// Reversing message using an array
char[] message = originalMessage.ToCharArray();
Array.Reverse(message);

// Counting the number of times a letter appears
int letterCount = 0;
foreach (char letter in message)
{
    if (letter == 'o')
    {
        letterCount++;
    }
}

// Printing the reversed message AND the number of times a letter appears
string newMessage = new String(message);
Console.WriteLine(newMessage);
Console.WriteLine($"The letter 'O' appears {letterCount} times.");


