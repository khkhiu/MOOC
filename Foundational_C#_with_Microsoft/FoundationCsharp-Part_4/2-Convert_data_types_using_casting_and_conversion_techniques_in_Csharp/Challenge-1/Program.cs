string[] values = { "12.3", "45", "ABC", "11", "DEF" };

decimal totalNumValue = 0m;
string totalMessage = "";

foreach (var arrayValue in values)
{
    // variable to store TryParse "out" value
    decimal sumNumValue;
    if (decimal.TryParse(arrayValue, out sumNumValue))
    {
        totalNumValue = totalNumValue + sumNumValue;
    }
    else 
    {
        totalMessage =  totalMessage + arrayValue; 
    }
}

Console.WriteLine($"Message: {totalNumValue}");
Console.WriteLine($"Total: {totalMessage}");