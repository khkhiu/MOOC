string orderStream = "B123,C234,A345,C15,B177,G3003,C235,B179";
// split orderStream into 'items' array
string[] items = orderStream.Split(',');
// Sort items array alphabetically
Array.Sort(items);

// mark element of 'items' array with 'error' if it's length is NOT 4
foreach (var item in items)
{
    if (item.Length == 4)
    {
        Console.WriteLine(item);
    }
    else
    {
        Console.WriteLine(item + "\t- Error");
    }
}