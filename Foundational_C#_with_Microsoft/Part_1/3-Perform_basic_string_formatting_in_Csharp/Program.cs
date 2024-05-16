/* 
Begin solving the challenge with the following two lines of code.
    string projectName = "ACME";
    string russianMessage = "\u041f\u043e\u0441\u043c\u043e\u0442\u0440\u0435\u0442\u044c \u0440\u0443\u0441\u0441\u043a\u0438\u0439 \u0432\u044b\u0432\u043e\u0434";

You may not change these two lines of code, but you can add code above and below each line. You must use these two lines of code to form the desired output.
    You may only use either the Console.WriteLine() or the Console.Write() method twice.

To complete this challenge, your code must produce the following output.

View English output:
  c:\Exercise\ACME\data.txt

Посмотреть русский вывод:
  c:\Exercise\ACME\ru-RU\data.txt

*/
string projectName = "ACME";
string russianMessage = "\u041f\u043e\u0441\u043c\u043e\u0442\u0440\u0435\u0442\u044c \u0440\u0443\u0441\u0441\u043a\u0438\u0439 \u0432\u044b\u0432\u043e\u0434";

string englishPath = $@"c:\Exercise\{projectName}\data.txt";
string russianPath = $@"c:\Exercise\{projectName}\ru-RU\data.txt";

Console.WriteLine($"View English output:\n\t{englishPath}");
Console.WriteLine($"{russianMessage}:\n\t{russianPath}");
