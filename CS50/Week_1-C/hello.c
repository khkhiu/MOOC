#include <cs50.h>
#include <stdio.h>

int main(void)
{
    //Declaring input type
    string input;
    //Prompt user for input
    input = get_string("What is your name?\n");
    printf("hello, %s\n", input);
}