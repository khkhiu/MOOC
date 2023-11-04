#include <cs50.h>
#include <stdio.h>
#include <string.h>

// Max number of candidates
#define MAX 9

// Candidates have name and vote count
typedef struct
{
    string name;
    int votes;
}
candidate;

// Array of candidates
candidate candidates[MAX];

// Number of candidates
int candidate_count;

// Function prototypes
bool vote(string name);
void print_winner(void);

int main(int argc, string argv[])
{
    // Check for invalid usage
    if (argc < 2)
    {
        printf("Usage: plurality [candidate ...]\n");
        return 1;
    }

    // Populate array of candidates
    candidate_count = argc - 1;
    // Limit candidate to 9
    if (candidate_count > MAX)
    {
        printf("Maximum number of candidates is %i\n", MAX);
        return 2;
    }
    // Assign candidate name to element in array
    // eg 0=Amy, 1=Bob, 2=Charlie etc.
    // Assign initial vote as zero
    for (int i = 0; i < candidate_count; i++)
    {
        candidates[i].name = argv[i + 1];
        candidates[i].votes = 0;
    }

    // Getting number of voters
    int voter_count = get_int("Number of voters: ");

    // Loop over all voters
    for (int i = 0; i < voter_count; i++)
    {
        // Prompting for vote using candidate name
        string name = get_string("Vote: ");
        // Check for invalid vote
        if (!vote(name))
        {
            printf("Invalid vote.\n");
        }
    }

    // Display winner of election
    print_winner();
}

/*
OPS:
[int main]
1. Enter name of candidates
2. Enter number of voters, 1 voter = 1 vote
3. Voters enter name of candidate

[bool vote]
4. prog checks name entered VS name of candidates
4a. if name matches, add 1 vote to candidate, return ture
4b. if name no match, no change vote, return false

[void print_winner]
*/

// Update vote totals given a new vote
bool vote(string name)
{
    // Candidate stored in array, hence run through all candidate names
    // eg 0=Amy, 1=Bob, 2=Charlie etc.
    for (int i = 0; i < candidate_count; i++)
    {
        // Use strcmp(first_str, second_str) to compare name of candidate
        if (strcmp(candidates[i].name, name) == 0)
        {
            // If true, add vote to candidate and return true
            candidates[i].votes++;
            return true;
        }

    }
    // if name != match, no vote change
    // return false
    return false;
}

// Print the winner (or winners) of the election
void print_winner(void)
{
    // Find out which candidate has the most votes
    // Let use max_votes to store candidate votes,
    int max_votes = 0;
    // Run through all candidates
    for (int i = 0; i < candidate_count; i++)
    {
        // Check the votes of each candidate, assign candidate[i].votes = max_votes
        // If a candidate wih more votes if found, overwrite exsisting value
        if (candidates[i].votes > max_votes)
        {
            /*
            NOTE:
            candidates[i].votes = max_votes
            will result in all candidates name being printed.
            */
            max_votes = candidates[i].votes;
        }
    }

    // print candidate with most votes
    for (int i = 0; i < candidate_count; i++)
    {
        if (candidates[i].votes == max_votes)
        {
            printf("%s\n", candidates[i].name);
        }
    }
    return;
}