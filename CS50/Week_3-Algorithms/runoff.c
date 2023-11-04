#include <cs50.h>
#include <stdio.h>
#include <string.h>

// Max voters and candidates
#define MAX_VOTERS 100
#define MAX_CANDIDATES 9

// preferences[i][j] is jth preference for voter i
int preferences[MAX_VOTERS][MAX_CANDIDATES];

// Candidates have name, vote count, eliminated status
typedef struct
{
    string name;
    int votes;
    bool eliminated;
}
candidate;

// Array of candidates
candidate candidates[MAX_CANDIDATES];

// Numbers of voters and candidates
int voter_count;
int candidate_count;

// Function prototypes
bool vote(int voter, int rank, string name);
void tabulate(void);
bool print_winner(void);
int find_min(void);
bool is_tie(int min);
void eliminate(int min);

int main(int argc, string argv[])
{
    // Check for invalid usage
    if (argc < 2)
    {
        printf("Usage: runoff [candidate ...]\n");
        return 1;
    }

    // Populate array of candidates
    candidate_count = argc - 1;
    if (candidate_count > MAX_CANDIDATES)
    {
        printf("Maximum number of candidates is %i\n", MAX_CANDIDATES);
        return 2;
    }
    //Populate array with candidate names using a for loop
    for (int i = 0; i < candidate_count; i++)
    {
        candidates[i].name = argv[i + 1];
        candidates[i].votes = 0;
        candidates[i].eliminated = false;
    }

    voter_count = get_int("Number of voters: ");
    if (voter_count > MAX_VOTERS)
    {
        printf("Maximum number of voters is %i\n", MAX_VOTERS);
        return 3;
    }

    // Keep querying for votes
    for (int i = 0; i < voter_count; i++)
    {

        // Query for each rank
        for (int j = 0; j < candidate_count; j++)
        {
            string name = get_string("Rank %i: ", j + 1);

            // Record vote, unless it's invalid
            if (!vote(i, j, name))
            {
                printf("Invalid vote.\n");
                return 4;
            }
        }

        printf("\n");
    }

    // Keep holding runoffs until winner exists
    while (true)
    {
        // Calculate votes given remaining candidates
        tabulate();

        // Check if election has been won
        bool won = print_winner();
        if (won)
        {
            break;
        }

        // Eliminate last-place candidates
        int min = find_min();
        bool tie = is_tie(min);

        // If tie, everyone wins
        if (tie)
        {
            for (int i = 0; i < candidate_count; i++)
            {
                if (!candidates[i].eliminated)
                {
                    printf("%s\n", candidates[i].name);
                }
            }
            break;
        }

        // Eliminate anyone with minimum number of votes
        eliminate(min);

        // Reset vote counts back to zero
        for (int i = 0; i < candidate_count; i++)
        {
            candidates[i].votes = 0;
        }
    }
    return 0;
}

/*
TODO: implement alternative voting system (First-past-the-vote system has been implemented in plurality.c)
see here for explanation: https://www.youtube.com/watch?v=3Y3jE3B8HsE
*/

// Record preference if vote is valid
// Valid = name is one of the candidates
bool vote(int voter, int rank, string name)
{
    // use 'c' for check
    for (int check = 0; check < candidate_count; check++)
    {
        //Reusing code from plurality.c
        // Use strcmp(first_str, second_str) to compare name of candidate
        if (strcmp(candidates[check].name, name) == 0)
        {
            // preferences[i][j] is jth preference for voter i
            // int preferences[MAX_VOTERS][MAX_CANDIDATES];
            // record valid preferences in 'preference' array
            preferences[voter][rank] = check;
            return true;
        }
    }
    return false;
}

// Tabulate votes for non-eliminated candidates
void tabulate(void)
{
    /*
    count votes of each candidate
    if candidate has not been eliminated, add +1 to vote
    cycle repeates until votes of all voters have been accounted for
    if candidate is eliminated,
    check if next ranked preferenfe is valid, +1 to that candidate if valid
    */
    for (int votes = 0; votes < voter_count; votes++)
    {
        for (int rank = 0; rank < candidate_count; rank++)
        {
            int count = preferences[votes][rank];
            if (candidates[count].eliminated == false)
            {
                candidates[count].votes++;
                break;
            }
        }
    }
}

// Print the winner of the election, if there is one at this point, runoff if only there is no winner
bool print_winner(void)
{
    //Check if candidate have more than 1/2 of all votes
    //if true, declare winner
    for (int vote_tally = 0; vote_tally < candidate_count; vote_tally++)
    {
        if (candidates[vote_tally].votes > (voter_count / 2))
        {
            printf("%s\n", candidates[vote_tally].name);
            return true;
        }
    }
    return false;
}

// The following FX are called if no candidate have more than 1/2 of all votes

// Return the minimum number of votes any remaining candidate has
// find candidates that are not eliminated and have the lowest number of votes
int find_min(void)
{
    int VoteCount = voter_count;
    for (int total_votes = 0; total_votes < candidate_count; total_votes++)
    {
        if (candidates[total_votes].votes < VoteCount && candidates[total_votes].eliminated == false)
        {
            VoteCount = candidates[total_votes].votes;
        }
    }
    return VoteCount;
}

// Return true if the election is tied between all candidates, false otherwise
bool is_tie(int min)
{
    int count_tie = 0; // Var to hold number of candidates still running
    int run_off = 0; // Var to hold how many candidates have minimum number of votes

    for (int count = 0; count < candidate_count; count++)
    {
        // +1 to count how many candidates are tied and have the minimum number of votes.
        if (candidates[count].eliminated == false && candidates[count].votes == min)
        {
            count_tie++;
            run_off++;
        }
        // +1 to run off if candidates have more than minimum number of votes.
        else if (candidates[count].eliminated == false)
        {
            run_off++;
        }
    }
    // Tie occurs if candidates are still running and have the minimum number of votes
    if (count_tie == run_off)
    {
        return true;
    }

    return false;
}

// Eliminate the candidate (or candidates) in last place
void eliminate(int min)
{
    for (int vote_count = 0; vote_count < candidate_count; vote_count++)
    {
        if (candidates[vote_count].eliminated == false && candidates[vote_count].votes == min)
        {
            candidates[vote_count].eliminated = true;
        }
    }
}