Project specification

The Starter code project for this module includes a Program.cs file with the following code features:

    The code declares variables used to collect and process pet data and menu item selections

    The code declares the ourAnimals array that includes the following information for each animal in the array:
        Pet ID #.
        Pet species (cat or dog).
        Pet age (years).
        A description of the pet's physical appearance.
        A description of the pet's personality.
        The pet's nickname.

    The code uses a for loop around a select-case construct to populate elements of the ourAnimals array.

    The code includes a loop around a main menu that terminates when the user enters "exit". The main menu includes:
        List all of our current pet information.
        Assign values to the ourAnimals array fields.
        Ensure animal ages and physical descriptions are complete.
        Ensure animal nicknames and personality descriptions are complete.
        Edit an animal’s age.
        Edit an animal’s personality description.
        Display all cats with a specified characteristic.
        Display all dogs with a specified characteristic.

    Enter menu item selection or type "Exit" to exit the program

    The code reads the user's menu item selection and uses a switch statement to branch the code for each menu item number.

    The code includes implementation for menu options 1 and 2.

    The code displays an "under construction" message for menu options 3-8.

Your goal in this challenge is to create the app features aligned with menu options 3 and 4.

To ensure that animal ages and physical descriptions are complete, your code must:

    Assign a valid numeric value to petAge for any animal that has been assigned data in the ourAnimals array but has not been assigned an age.
    Assign a valid string to petPhysicalDescription for any animal that has been assigned data in the ourAnimals array but has not been assigned a physical description.
    Verify that physical descriptions have an assigned value. Assigned values cannot have zero characters. Any further requirement is up to you.

To ensure that animal nicknames and personality descriptions are complete, your code must:

    Assign a valid string to petNickname for any animal that has been assigned data in the ourAnimals array but has not been assigned a nickname.
    Assign a valid string to petPersonalityDescription for any animal that has been assigned data in the ourAnimals array but has not been assigned a personality description.
    Verify that nicknames and personality descriptions have an assigned value. Assigned values cannot have zero characters. Any further requirement is up to you.
