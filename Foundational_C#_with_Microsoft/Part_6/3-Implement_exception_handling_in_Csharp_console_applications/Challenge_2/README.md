Catch specific exceptions challenge

In this challenge, you're provided with a code sample that generates several different exception types. A single try code block contains the code that generates the exceptions. Multiple catch clauses are included to handle specific exception types.

You need to update the code sample so that each exception is caught and the corresponding error message is displayed to the console.

Here are the requirements for this challenge:

    Ensure that your Program.cs file contains the following code sample:
    C# 

try
{
    int num1 = int.MaxValue;
    int num2 = int.MaxValue;
    int result = num1 + num2;
    Console.WriteLine("Result: " + result);

    string str = null;
    int length = str.Length;
    Console.WriteLine("String Length: " + length);

    int[] numbers = new int[5];
    numbers[5] = 10;
    Console.WriteLine("Number at index 5: " + numbers[5]);

    int num3 = 10;
    int num4 = 0;
    int result2 = num3 / num4;
    Console.WriteLine("Result: " + result2);
}
catch (OverflowException ex)
{
    Console.WriteLine("Error: The number is too large to be represented as an integer." + ex.Message);
}
catch (NullReferenceException ex)
{
    Console.WriteLine("Error: The reference is null." + ex.Message);
}
catch (IndexOutOfRangeException ex)
{
    Console.WriteLine("Error: Index out of range." + ex.Message);
}
catch (DivideByZeroException ex)
{
    Console.WriteLine("Error: Cannot divide by zero." + ex.Message);
}

Console.WriteLine("Exiting program.");

Update the code so that each error message is displayed to the console when that exception type occurs.

Verify that your updated code prints the following messages to the console:
Output

Error: The number is too large to be represented as an integer. Arithmetic operation resulted in an overflow.
Error: The reference is null. Object reference not set to an instance of an object.
Error: Index out of range. Index was outside the bounds of the array.
Error: Cannot divide by zero. Attempted to divide by zero.
Exiting program.