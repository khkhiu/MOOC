Try-Catch challenge

Implement exception handling to satisfy the following challenge parameters:

    Start with the following application code:
    C# 

try
{
    Process1();
}
catch
{
    Console.WriteLine("An exception has occurred");
}

Console.WriteLine("Exit program");

static void Process1()
{
    WriteMessage();
}

static void WriteMessage()
{
    double float1 = 3000.0;
    double float2 = 0.0;
    int number1 = 3000;
    int number2 = 0;

    Console.WriteLine(float1 / float2);
    Console.WriteLine(number1 / number2);
}

Update the Process1 method to catch the exception that's thrown in the WriteMessage method.

The Process1 method should print the following message to console when the exception is caught:
Output

Exception caught in Process1

Don't change any code outside the Process1 method.

When you run your updated application, it should generate the following output:
Output

∞
Exception caught in Process1
Exit program

For the purposes of this challenge, you can ignore the output messages created by the debugger. For example, you can ignore the following messages:
Output

    Exception thrown: 'System.DivideByZeroException' in Exceptions101.dll

    The program '[436] Exceptions101.dll' has exited with code 0 (0x0).

