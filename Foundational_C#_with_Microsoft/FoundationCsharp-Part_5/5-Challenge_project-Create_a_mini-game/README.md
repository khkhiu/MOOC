Project specification

The Starter code project for this module includes a Program.cs file with the following code features:
Output

- The code declares the following variables:
    - Variables to determine the size of the Terminal window.
    - Variables to track the locations of the player and food.
    - Arrays `states` and `foods` to provide available player and food appearances
    - Variables to track the current player and food appearance

- The code provides the following methods:
    - A method to determine if the Terminal window was resized.
    - A method to display a random food appearance at a random location.
    - A method that changes the player appearance to match the food consumed.
    - A method that temporarily freezes the player movement.
    - A method that moves the player according to directional input.
    - A method that sets up the initial game state.

- The code doesn't call the methods correctly to make the game playable. The following features are missing:
    - Code to determine if the player has consumed the food displayed.
    - Code to determine if the food consumed should freeze player movement.
    - Code to determine if the food consumed should increase player movement.
    - Code to increase movement speed.
    - Code to redisplay the food after it's consumed by the player.
    - Code to terminate execution if an unsupported key is entered.
    - Code to terminate execution if the terminal was resized.

Your goal in this challenge is to use the existing features and create the missing features to make the game playable.

Specification

In this challenge exercise, you need to update the existing code to support an option to terminate the gameplay if a nondirectional character is entered. You also want to terminate the game if the terminal window was resized. You need to locate the correct methods for your code to use.
Terminate on resize

This feature must:

    Determine if the terminal was resized before allowing the game to continue
    Clear the Console and end the game if the terminal was resized
    Display the following message before ending the program: Console was resized. Program exiting.

Add optional termination

    Modify the existing Move method to support an optional parameter
    If enabled, the optional parameter should detect nondirectional key input
    If nondirectional input is detected, allow the game to terminate

