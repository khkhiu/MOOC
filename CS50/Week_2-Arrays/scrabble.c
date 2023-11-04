#include <ctype.h>
#include <cs50.h>
#include <stdio.h>
#include <string.h>

// Points assigned to each letter of the alphabet
int POINTS[] = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

int compute_score(string word);

int main(void)
{
    // Get input words from both players
    string word1 = get_string("Player 1: ");
    string word2 = get_string("Player 2: ");

    // Score both words
    int score1 = compute_score(word1);
    int score2 = compute_score(word2);

    // TODO: Print the winner
    if (score1 > score2)
    {
        printf("Player 1 wins!\n");
        printf("%d\n", score1);
        printf("%d\n", score2);
    }
    else if (score2 > score1)
    {
        printf("Player 2 wins!\n");
        printf("%d\n", score1);
        printf("%d\n", score2);
    }
    else
    {
        printf("Tie!\n");
        printf("%d\n", score1);
        printf("%d\n", score2);
    }
}

int compute_score(string word)
{
    // TODO: Compute and return score for string
    int score = 0;
    for (int i = 0; i < strlen(word); i++)
    {
        //Counting score for lowercase
        if (islower(word[i]))
        {
            //Use values of POINTS array instead of ASCII table
            //'-97' as lowercase 'a' has an ASCII value of 97
            //This also signals that 'word' is an 'int' rather than 'char'
            //Thus matching the lowercase alphabet to the POINTS array
            score += POINTS[word[i] - 97];
        }
        //Counting score for lowercase
        else if (isupper(word[i]))
        {
            //Use values of POINTS array instead of ASCII table
            //Upper and lowercase alphabet have different ASCII values
            //'-65' as lowercase 'a' has an ASCII value of 65
            //This also signals that 'word' is an 'int' rather than 'char'
            //Thus matching the lowercase alphabet to the POINTS array
            score += POINTS[word[i] - 65];
        }
    }
    return score;
}
