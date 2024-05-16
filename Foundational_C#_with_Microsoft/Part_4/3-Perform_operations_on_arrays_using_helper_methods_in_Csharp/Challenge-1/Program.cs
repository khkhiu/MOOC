string pangram = "The quick brown fox jumps over the lazy dog";

// Split pangram using spaces as a seperator
string[] messageSplit = pangram.Split(' ');

// Create a new array using messageSplit as elements
string[] newMessage = new string[messageSplit.Length];

// iterate over length of messageSplit
for (int i = 0; i < messageSplit.Length; i++)
{   
    // Convert messageSplit into a character array
    char[] letters = messageSplit[i].ToCharArray();
    // Reverse sequence of letters
    Array.Reverse(letters);
    // Convert the reversed letters array back to a string
    newMessage[i] = new string(letters);
}

// Concatenate elements of 'newMessage' into 'result'
string result = String.Join(" ", newMessage);
Console.WriteLine(result);