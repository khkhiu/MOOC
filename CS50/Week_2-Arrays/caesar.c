#include <cs50.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

/*
TODO:
1. prompt for secret eky
1a. show 'usage: ./ caesar key' if input !- non-negative int
2. prompt for plain text
3. show cipher text
*/

//Prototype declaration
void cipher_text(string plain_text, int input_key);

//argc = number of arguments being passed into program from the command line
//argv is the array of arguments.
int main(int argc, string argv[])
{
    //Prog only exe with one command line argument
    // './ceasar' counts as 1 argument
    //check if only 2 arguments exsist
    if (argc == 2)
    {
        //Check if argument are numbers
        for (int i = 0; i < strlen(argv[1]); i++)
        {
            //Reject input if arguments are not number
            if (isdigit(argv[1][i]) == false)
            {
                printf("Usage: ./caesar key\n");
                return 1;
            }
        }
        //Check if input is a positive integer
        //If input = positive integer, prompt for plaintext input
        int input_key = atoi(argv[1]);
        if (input_key > 0)
        {
            //Prompting for input
            string plain_text = get_string("plaintext: ");
            //printf("%s\n", plain_text);
            //Printing cipher text
            //FX call cipher_text values
            printf("ciphertext: ");
            cipher_text(plain_text, input_key);
            printf("\n");
            return 0;
        }
        else
        {
            printf("Usage: ./caesar key\n");
            return 1;
        }
    }
    else
    {
        printf("Usage: ./caesar key\n");
        return 1;
    }
}

//void to return nothing, accept plaintext and key from int main
void cipher_text(string plain_text, int input_key)
{
    for (int i = 0; i < strlen(plain_text); i++)
    {
        //Restrict ASCII to alphabet only for lower case
        //plain_text[i] to use ASCII position
        if (plain_text[i] >= 'a' && plain_text[i] <= 'z')
        {
            /*
            OPS:
            1. Subtract 'a' to obtain ACSII position of zero
            2. add input_key to obtain new temp ACSII position
            3. %26 from problem statement
            4. Add 'a' to obtain new ACSII position
            5* Use %c in printf to char that corresponds to the ASCII position
            NOTE:
            26%26 == 0 == NULL (in ASCII)
            */
            printf("%c", ((plain_text[i] - 'a' + input_key) % 26) + 'a');
        }
        //Restrict ASCII to alphabet only for upper case
        //plain_text[i] to use ASCII position
        else if (plain_text[i] >= 'A' && plain_text[i] <= 'Z')
        {
            /*
            OPS:
            1. Subtract 'a' to obtain ACSII position of zero
            2. add input_key to obtain new temp ACSII position
            3. %26 from problem statement
            4. Add 'a' to obtain new ACSII position
            5* Use %c in printf to char that corresponds to the ASCII position
            NOTE:
            26%26 == 0 == NULL (in ASCII)
            */
            printf("%c", ((plain_text[i] - 'A' + input_key) % 26) + 'A');
        }
        /*
        ASCII OPS illustration:
        input_key = 1
        plain_text = A
        (plain_text[i] - 'A' + input_key) % 26) + 'A'
        (65 - 65 + 1) % 26 + 65
        (1 % 26) + 65
        66 == B
        */
        else
        {
            //Keep all other chars
            //Use %c in printf to char that corresponds to the ASCII position
            printf("%c", plain_text[i]);
        }
    }
}
