#include <cs50.h>
#include <stdio.h>

int main(void)
{
    /*TODO:
    Prompt for start size
    Start size must be more than 9, repromt in input less than 9
    */
   int start;
   do
   {
        start = get_int("Input starting population size: ");
   }
   while (start < 9);

    /*TODO:
    Prompt for end size
    End size must be more than or equal start size, reprompt otherwise
    */
    int end;
    do
    {
        end = get_int("Input ending population size: ");
    }
    while (end < start);

    // TODO: Calculate number of years until we reach threshold
    int year = 0;

    // If start size and end size are the same, print years = 0
    if (start == end)
    {
        printf("Years: 0\n");
    } else {
    // Calculate if start size and end size are different.
    do
    {
        //New size = original size + new - old
        start = start + (start/3)-(start/4);
        year ++;
    }
    while (start < end);
    // TODO: Print number of years
    printf("Years: %i\n", year);
    }
}
