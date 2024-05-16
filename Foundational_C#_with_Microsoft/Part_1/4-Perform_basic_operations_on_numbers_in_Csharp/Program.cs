/* 
Convert temperatures in degrees Fahrenheit to Celsius, first subtract 32, then multiply by five ninths (5 / 9).

Display the result of the temperature conversion in a formatted message

Combine the variables with literal strings passed into a series of Console.WriteLine() commands to form the complete message.


*/
int fahrenheit = 94;
float celsius = (fahrenheit - 32f) * (5/9f);
Console.WriteLine("The temperature is " + celsius + " Celsius.");