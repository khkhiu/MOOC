#include <cs50.h>
#include <stdio.h>

/*TO DO:
1. Ask users for input levels of '#'
1a.Only accept input between 1 and 8 inclusive
2. Add 1 '#' for every subsequent level
3. Reprompt
*/

int main(void)
{
    // Ask for input
    int height;
    do
    {
        height = get_int("Height: ");
    }

    //Accept only values between 1 and 8
    while (height < 1 || height > 8);

    //Generating '#'
    //'level'= number or rows of '#'
    for (int level = 0; level < height; level++)
    {
        for (int space = height - level - 1; space > 0; space --)
        {
            printf(" ");
        }
        // Print '#' in accordance with value of 'level', start at -1 to ensure that level 1 =  hex 1 etc.
        for (int hex = -1; hex < level; hex ++)
        {
            printf("#");
        }
        printf("\n");
    }
}