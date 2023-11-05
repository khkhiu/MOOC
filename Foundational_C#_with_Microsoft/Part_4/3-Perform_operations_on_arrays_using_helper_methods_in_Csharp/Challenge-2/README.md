Exercise - Complete a challenge to parse a string of orders, sort the orders and tag possible errors
Completed 100 XP

Data comes in many formats. In this challenge you have to parse the individual "Order IDs", and output the "OrderIDs" sorted and tagged as "Error" if they aren't exactly four characters in length.

    Select and delete all code lines in the Visual Studio Code Editor.

    In Visual Studio Code, add the following code to get the data for the challenge:
    C# 

string orderStream = "B123,C234,A345,C15,B177,G3003,C235,B179";

Notice in the previous code, the orderStream variable contains a string of multiple Order IDs separated by commas

Add code below the previous code to parse the "Order IDs" from the string of incoming orders and store the "Order IDs" in an array

Add code to output each "Order ID" in sorted order and tag orders that aren't exactly four characters in length as "- Error"

Save and run your code

Your code must produce the following output:
Output

A345
B123
B177
B179
C15     - Error
C234
C235
G3003   - Error
