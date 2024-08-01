﻿// the ourAnimals array will store the following: 
string animalSpecies = "";
string animalID = "";
string animalAge = "";
string animalPhysicalDescription = "";
string animalPersonalityDescription = "";
string animalNickname = "";

// variables that support data entry
int maxPets = 8;
string? readResult;
string menuSelection = "";

// array used to store runtime data, there is no persisted data
string[,] ourAnimals = new string[maxPets, 6];

// TODO: Convert the if-elseif-else construct to a switch statement
// create some initial ourAnimals array entries
for (int i = 0; i < maxPets; i++)
{
    switch (i)
    {
        case 0:
            animalSpecies = "dog";
            animalID = "d1";
            animalAge = "2";
            animalPhysicalDescription = "medium sized cream colored female golden retriever weighing about 65 pounds. housebroken.";
            animalPersonalityDescription = "loves to have her belly rubbed and likes to chase her tail. gives lots of kisses.";
            animalNickname = "lola";
            break;

        case 1:
            animalSpecies = "dog";
            animalID = "d2";
            animalAge = "9";
            animalPhysicalDescription = "large reddish-brown male golden retriever weighing about 85 pounds. housebroken.";
            animalPersonalityDescription = "loves to have his ears rubbed when he greets you at the door, or at any time! loves to lean-in and give doggy hugs.";
            animalNickname = "loki";
            break;

        case 2:
            animalSpecies = "cat";
            animalID = "c3";
            animalAge = "1";
            animalPhysicalDescription = "small white female weighing about 8 pounds. litter box trained.";
            animalPersonalityDescription = "friendly";
            animalNickname = "Puss";
            break;

        case 3:
            animalSpecies = "cat";
            animalID = "c4";
            animalAge = "?";
            animalPhysicalDescription = "";
            animalPersonalityDescription = "";
            animalNickname = "";
            break;

        default:
            animalSpecies = "";
            animalID = "";
            animalAge = "";
            animalPhysicalDescription = "";
            animalPersonalityDescription = "";
            animalNickname = "";
            break;

    }

    ourAnimals[i, 0] = "ID #: " + animalID;
    ourAnimals[i, 1] = "Species: " + animalSpecies;
    ourAnimals[i, 2] = "Age: " + animalAge;
    ourAnimals[i, 3] = "Nickname: " + animalNickname;
    ourAnimals[i, 4] = "Physical description: " + animalPhysicalDescription;
    ourAnimals[i, 5] = "Personality: " + animalPersonalityDescription;
}

// display all menu options
do
{
    Console.Clear();

    Console.WriteLine("Welcome to the Contoso PetFriends app. Your main menu options are:");
    Console.WriteLine(" 1. List all of our current pet information");
    Console.WriteLine(" 2. Add a new animal friend to the ourAnimals array");
    Console.WriteLine(" 3. Ensure animal ages and physical descriptions are complete");
    Console.WriteLine(" 4. Ensure animal nicknames and personality descriptions are complete");
    Console.WriteLine(" 5. Edit an animal’s age");
    Console.WriteLine(" 6. Edit an animal’s personality description");
    Console.WriteLine(" 7. Display all cats with a specified characteristic");
    Console.WriteLine(" 8. Display all dogs with a specified characteristic");
    Console.WriteLine();
    Console.WriteLine("Enter your selection number (or type Exit to exit the program)");

    readResult = Console.ReadLine();
    if (readResult != null)
    {
        menuSelection = readResult.ToLower();
    }

    // use switch-case to select menu
    switch (menuSelection)
{
    case "1":
        // List all current pet information
        for (int i = 0; i < maxPets; i++)
        {
            if (ourAnimals[i, 0] != "ID #: ")
            {
                Console.WriteLine();
                for (int j = 0; j < 6; j++)
                {
                    Console.WriteLine(ourAnimals[i, j]);
                }
            }
        }
        Console.WriteLine("\n\rPress the Enter key to continue");
        readResult = Console.ReadLine();
    break;

    case "2":
        // populate ourAnimals array
        string anotherPet = "y";
        int petCount = 0;
        for (int i = 0; i < maxPets; i++)
        {
        if (ourAnimals[i, 0] != "ID #: ")
            {
                petCount += 1;
            }
        }

        if (petCount < maxPets)
        {
            Console.WriteLine($"We currently have {petCount} pets that need homes. We can manage {(maxPets - petCount)} more.");
        }

        while (anotherPet == "y" && petCount < maxPets)
        {
        bool validEntry = false;    
        // get dog or cat
        do
        {
            Console.WriteLine("\n\rEnter 'dog' or 'cat' to begin a new entry");
                readResult = Console.ReadLine();
                if (readResult != null)
                {
                    animalSpecies = readResult.ToLower();
                    if (animalSpecies != "dog" && animalSpecies != "cat")
                    {
                        //Console.WriteLine($"You entered: {animalSpecies}.");
                        validEntry = false;
                    }
                    else
                    {
                        validEntry = true;
                    }
                }
            } while (validEntry == false);

            // get animal ID number 
            animalID = animalSpecies.Substring(0, 1) + (petCount + 1).ToString();
                do
                {
                int petAge;
                Console.WriteLine("Enter the pet's age or enter ? if unknown");
                readResult = Console.ReadLine();
                if (readResult != null)
                {
                    animalAge = readResult;
                    if (animalAge != "?")
                    {
                        validEntry = int.TryParse(animalAge, out petAge);
                    }
                    else
                    {
                        validEntry = true;
                    }
                }
            } while (validEntry == false);
            // get description of pet's physical appearance
            do
            {
                Console.WriteLine("Enter a physical description of the pet (size, color, gender, weight, housebroken)");
                readResult = Console.ReadLine();
                if (readResult != null)
                {
                    animalPhysicalDescription = readResult.ToLower();
                    if (animalPhysicalDescription == "")
                    {
                        animalPhysicalDescription = "tbd";
                    }
                }
            } while (animalPhysicalDescription == "");
            // get pet's personality, can be blank
            {
                Console.WriteLine("Enter a description of the pet's personality (likes or dislikes, tricks, energy level)");
                readResult = Console.ReadLine();
                if (readResult != null)
                {
                    animalPersonalityDescription = readResult.ToLower();
                    if (animalPersonalityDescription == "")
                    {
                        animalPersonalityDescription = "tbd";
                    }
                }
            } while (animalPersonalityDescription == "");
            // get pet nickname, can be left blank.
            do
            {
                Console.WriteLine("Enter a nickname for the pet");
                readResult = Console.ReadLine();
                if (readResult != null)
                {
                    animalNickname = readResult.ToLower();
                    if (animalNickname == "")
                    {
                        animalNickname = "tbd";
                    }
                }
            } while (animalNickname == "");
            // store information in ourAnimals array
            ourAnimals[petCount, 0] = "ID #: " + animalID;
            ourAnimals[petCount, 1] = "Species: " + animalSpecies;
            ourAnimals[petCount, 2] = "Age: " + animalAge;
            ourAnimals[petCount, 3] = "Nickname: " + animalNickname;
            ourAnimals[petCount, 4] = "Physical description: " + animalPhysicalDescription;
            ourAnimals[petCount, 5] = "Personality: " + animalPersonalityDescription;

            petCount = petCount + 1;
            // check maxPet limit
            if (petCount < maxPets)
            {
                // prompt for another pet
                Console.WriteLine("Do you want to enter info for another pet (y/n)");
                do
                {
                    readResult = Console.ReadLine();
                    if (readResult != null)
                    {
                        anotherPet = readResult.ToLower();
                    }
                } while (anotherPet != "y" && anotherPet != "n");
            }
        }
        if (petCount >= maxPets)
        {
            Console.WriteLine("We have reached our limit on the number of pets that we can manage.");
            Console.WriteLine("Press the Enter key to continue.");
            readResult = Console.ReadLine();
        }
        break;

        case "3":
        // Complete animal age and physical description
        Console.WriteLine("Challenge Project - please check back soon to see progress.");
        Console.WriteLine("Press the 'Enter' to terminate program.");
        readResult = Console.ReadLine();
        break;

        case "4":
        // Complete animal nicknames and personality description
        Console.WriteLine("UNDER CONSTRUCTION - please check back next month to see progress.");
        Console.WriteLine("Press the 'Enter' to terminate program.");
        readResult = Console.ReadLine();
        break;

        case "5":
        // Change age of animal;
        Console.WriteLine("UNDER CONSTRUCTION - please check back next month to see progress.");
        Console.WriteLine("Press the 'Enter' to terminate program.");
        readResult = Console.ReadLine();
        break;

        case "6":
        // Change animal description
        Console.WriteLine("UNDER CONSTRUCTION - please check back next month to see progress.");
        Console.WriteLine("Press the 'Enter' to terminate program.");
        readResult = Console.ReadLine();
        break;
        
        case "7":
        // Filter cat
        Console.WriteLine("UNDER CONSTRUCTION - please check back next month to see progress.");
        Console.WriteLine("Press the 'Enter' to terminate program.");
        readResult = Console.ReadLine();
        break;

        case "8":
        // Filter dog
        Console.WriteLine("UNDER CONSTRUCTION - please check back next month to see progress.");
        Console.WriteLine("Press the 'Enter' to terminate program.");
        readResult = Console.ReadLine();
        break;

        default:
        break;
}

} while (menuSelection != "exit");


