// Import the System namespace to access classes like Random and Console.
using System;

// Create an instance of Random for generating random numbers.
Random random = new Random();

// Hide the cursor to make the game interface cleaner.
Console.CursorVisible = false;

// Define the height and width of the game area based on the console window size.
int height = Console.WindowHeight - 1;
int width = Console.WindowWidth - 5;

// Variable to control the game loop exit.
bool shouldExit = false;

// Initialize player position.
int playerX = 0;
int playerY = 0;

// Initialize food position.
int foodX = 0;
int foodY = 0;

// Arrays to store different player states and food types.
string[] states = {"('-')", "(^-^)", "(X_X)"};
string[] foods = {"@@@@@", "$$$$$", "#####"};

// Current player state displayed in the console.
string player = states[0];

// Index to track the current food type.
int food = 0;

// Initialize the game.
InitializeGame();

// Main game loop.
while (!shouldExit) 
{
    // Check if the terminal was resized.
    if (TerminalResized())
    {
        Console.Clear();
        Console.Write("Console resized. Program exiting");
        shouldExit = true;
    }
    else
    {
        // Check player conditions and move accordingly.
        if (PlayerIsFaster())
        {
            Move(1, false);
        }
        else if (PlayerIsSick())
        {
            FreezePlayer();
        }
        else
        {
            Move(otherKeysExit: false);
        }

        // Check if the player got food and update the game accordingly.
        if (GotFood())
        {
            ChangePlayer();
            ShowFood();
        }
    }
}

// Function to check if the terminal was resized.
bool TerminalResized() 
{
    return height != Console.WindowHeight - 1 || width != Console.WindowWidth - 5;
}

// Function to display random food at a random location.
void ShowFood() 
{
    // Update food to a random index.
    food = random.Next(0, foods.Length);

    // Update food position to a random location within the game area.
    foodX = random.Next(0, width - player.Length);
    foodY = random.Next(0, height - 1);

    // Display the food at the location.
    Console.SetCursorPosition(foodX, foodY);
    Console.Write(foods[food]);
}

// Function to check if the player has collected food.
bool GotFood()
{
    return playerY == foodY && playerX == foodX;
}

// Function to check if the player is in a sick state.
bool PlayerIsSick()
{
    return player.Equals(states[2]);
}

// Function to check if the player is in a faster state.
bool PlayerIsFaster()
{
    return player.Equals(states[1]);
}

// Function to change the player state based on the collected food.
void ChangePlayer() 
{
    player = states[food];
    Console.SetCursorPosition(playerX, playerY);
    Console.Write(player);
}

// Function to temporarily stop the player from moving.
void FreezePlayer() 
{
    System.Threading.Thread.Sleep(1000); // Sleep for 1 second.
    player = states[0]; // Set the player state back to normal.
}

// Function to read directional input from the console and move the player.
void Move(int speed = 1, bool otherKeysExit = false) 
{
    // Store the previous player position.
    int lastX = playerX;
    int lastY = playerY;
    
    // Read a keypress from the console and move the player accordingly.
    switch (Console.ReadKey(true).Key) 
    {
        case ConsoleKey.UpArrow:
            playerY--; 
            break;
        case ConsoleKey.DownArrow: 
            playerY++; 
            break;
        case ConsoleKey.LeftArrow:  
            playerX = playerX - speed; 
            break;
        case ConsoleKey.RightArrow: 
            playerX = playerX + speed; 
            break;
        case ConsoleKey.Escape:     
            shouldExit = true; 
            break;
        default:
            shouldExit = otherKeysExit;
            break;
    }

    // Clear the characters at the previous position.
    Console.SetCursorPosition(lastX, lastY);
    for (int i = 0; i < player.Length; i++) 
    {
        Console.Write(" ");
    }

    // Ensure the player position stays within the bounds of the game area.
    playerX = (playerX < 0) ? 0 : (playerX >= width ? width : playerX);
    playerY = (playerY < 0) ? 0 : (playerY >= height ? height : playerY);

    // Draw the player at the new location.
    Console.SetCursorPosition(playerX, playerY);
    Console.Write(player);
}

// Function to initialize the game.
void InitializeGame() 
{
    // Clear the console, display the food, and set the initial player position.
    Console.Clear();
    ShowFood();
    Console.SetCursorPosition(0, 0);
    Console.Write(player);
}
