// Import the System namespace to access classes like Random and Console.
using System;

// Define an array of strings called "pettingZoo" containing names of animals.
string[] pettingZoo = 
{
    "alpacas", "capybaras", "chickens", "ducks", "emus", "geese", 
    "goats", "iguanas", "kangaroos", "lemurs", "llamas", "macaws", 
    "ostriches", "pigs", "ponies", "rabbits", "sheep", "tortoises",
};

// Plan school visits for different schools and specify the number of groups for each school.
PlanSchoolVisit("School A", 1);
PlanSchoolVisit("School B", 3);
PlanSchoolVisit("School C", 2);

// Define function to plan a school visit.
void PlanSchoolVisit(string schoolName, int groups = 6) 
{
    // Shuffle the order of animals in the pettingZoo array.
    RandomizeAnimals(); 

    // Assign animals to groups and store the result in "group1."
    string[,] group1 = AssignGroup(groups);

    // Print the school name.
    Console.WriteLine(schoolName);

    // Print the groups and the assigned animals for this school.
    PrintGroup(group1);
}

// Define function to randomly shuffle the "pettingZoo" array.
void RandomizeAnimals() 
{
    // Create a new instance of the Random class.
    Random random = new Random();

    // Iterate through each element in the "pettingZoo" array.
    for (int i = 0; i < pettingZoo.Length; i++) 
    {
        // Generate a random index "r" between "i" and the length of the array.
        int r = random.Next(i, pettingZoo.Length);

        // Swap the elements at index "i" and "r" to shuffle the array randomly.
        string temp = pettingZoo[r];
        pettingZoo[r] = pettingZoo[i];
        pettingZoo[i] = temp;
    }
}

// Define a function to assign animals to groups.
string[,] AssignGroup(int groups = 6) 
{
    // Create a two-dimensional string array "result" to store group assignments.
    string[,] result = new string[groups, pettingZoo.Length / groups];
    int start = 0;

    // Iterate through the number of groups.
    for (int i = 0; i < groups; i++) 
    {
        // Iterate through each group and assign animals.
        for (int j = 0; j < result.GetLength(1); j++) 
        {
            result[i, j] = pettingZoo[start++];
        }
    }

    // Return the group assignments.
    return result;
}

// Define function to print the assigned groups and animals.
void PrintGroup(string[,] groups) 
{
    // Iterate through each group.
    for (int i = 0; i < groups.GetLength(0); i++) 
    {
        // Print the group number.
        Console.Write($"Group {i + 1}: ");

        // Iterate through animals in the group and print them.
        for (int j = 0; j < groups.GetLength(1); j++) 
        {
            Console.Write($"{groups[i, j]}  ");
        }

        // Move to the next line for the next group.
        Console.WriteLine();
    }
}
