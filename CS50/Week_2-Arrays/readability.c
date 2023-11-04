#include <cs50.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

//Declare prototype
int count_letters(string text);
int count_words(string text);
int count_sentences(string text);

int main(void)
{
    //TODO: Takes a text and determines its reading level.
    /*
    Example: index = 0.0588 * L - 0.296 * S - 15.8
    L is the average number of letters per 100 words in the text,
    S is the average number of sentences per 100 words in the text.
    */

    //User input
    string text = get_string("Text: ");

    //Printing number of letters
    float print_letter_count = count_letters(text);
    printf("Number of letters: %f\n", print_letter_count);

    //Printing number of words
    float print_word_count = count_words(text);
    printf("Number of words: %f\n", print_word_count);

    //Printing number of sentences
    float print_sentence_count = count_sentences(text);
    printf("Number of sentences: %f\n", print_sentence_count);

    //Compute and print grade level
    float L = 100 * (print_letter_count / print_word_count);
    float S = 100 * (print_sentence_count / print_word_count);
    float index = 0.0588 * L - 0.296 * S - 15.8;
    int round_index = round(index);
    if (index > 16)
    {
        printf("Grade 16+\n");
    }
    else if (index < 1)
    {
        printf("Before Grade 1\n");
    }
    else
    {
        printf("Grade %d\n", round_index);
    }
}

int count_letters(string text)
{
    //Counting letters
    int letters = 0;

    for (int i = 0; i < strlen(text); i++)
    {
        //use an array to count number of characters in 'letter_count', including spaces
        char letter_count = text[i];
        //increment 'letters' if alphabet is found in 'letter_count'
        if (isalpha(letter_count))
        {
            letters++;
        }
    }
    return letters;
}

int count_words(string text)
{
    //Counting spaces
    int spaces = 0;
    int words = 0;

    for (int i = 0; i < strlen(text); i++)
    {
        //use an array to count number of paces in 'text'
        char space_count = text[i];
        //increment 'spaces' if  is found in 'space_count'
        //word = number of spaces plus 1
        if (isspace(space_count))
        {
            spaces++;
            words = 1 + spaces;
        }
    }
    return words;
}

int count_sentences(string text)
{
    //Counting punctuation
    int punctuation = 0;

    for (int i = 0; i < strlen(text); i++)
    {
        //use an array to count punctuation of paces in 'text'
        char punct_count = text[i];
        //increment 'spaces' if  is found in 'punct_count'
        if (punct_count == '.' || punct_count == '?' || punct_count == '!')
        {
            punctuation++;
        }
    }
    return punctuation;
}