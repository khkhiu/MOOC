/* 
Here are the FizzBuzz rules that you need to implement in your code project:

    Output values from 1 to 100, one number per line, inside the code block of an iteration statement.
    When the current value is divisible by 3, print the term Fizz next to the number.
    When the current value is divisible by 5, print the term Buzz next to the number.
    When the current value is divisible by both 3 and 5, print the term FizzBuzz next to the number.
*/

// Use modulus operator to find remainder
for (int i = 1; i < 101; i++)
{
    if ((i % 3 == 0) && (i % 5 == 0))
        {
            Console.WriteLine($"{i} - FizzBuzz");
        }
    else if (i % 3 == 0)
        {
            Console.WriteLine($"{i} - Fizz");
        }
    else if (i % 5 == 0)
        {
            Console.WriteLine($"{i} - Buzz");
        }
    else
        {
            Console.WriteLine($"{i}");
        } 
}