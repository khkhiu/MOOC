// Implements a dictionary's functionality

#include <ctype.h>
#include <stdbool.h>
#include <string.h>
#include <strings.h>
#include <stdlib.h>
#include <stdio.h>
#include "dictionary.h"

//Declaring VAR
unsigned int word_count;
unsigned int hash_value;


// Represents a node in a hash table
typedef struct node
{
    char word[LENGTH + 1];
    struct node *next;
}
node;

// TODO: Choose number of buckets in hash table
const unsigned int N = 26;

// Hash table
node *table[N];

// Returns true if word is in dictionary, else false
bool check(const char *word)
{
    // TODO
    // Hash word to obtain hash value
    hash_value = hash(word);

    // Move cursor to first node
    node *cursor = table[hash_value];

    // scan through linked list
    while (cursor != 0)
    {
        if (strcasecmp(word, cursor->word) == 0)
        {
            return true;
        }
        cursor = cursor->next;
    }
    return false;
}

// Hashes word to a number
unsigned int hash(const char *word)
{
    // TODO: Improve this hash function
    unsigned long total = 0;
    for (int i = 0; i < strlen(word); i++)
    {
        total = total + tolower(word[i]);
    }
    return total % N;
}

// Loads dictionary into memory, returning true if successful, else false
bool load(const char *dictionary)
{
    // TODO
    // Open dictionary, return NULL if file cannot be open
    FILE *file = fopen(dictionary, "r");
    if (file == NULL)
    {
        return NULL;
    }
    // Declare word variable
    char word[LENGTH + 1];

    // Scan dictionary for strings until end of file
    while (fscanf(file, "%s", word) != EOF)
    {
        // Allocate memory for new node, if malloc == NULL, return NULL.
        node *n = malloc(sizeof(node));
        if (n == NULL)
        {
            return NULL;
        }

        // Copying word into node
        strcpy(n->word, word);
        hash_value = hash(word);
        n->next = table[hash_value];
        table[hash_value] = n;
        word_count++;
    }
    fclose(file);
    return true;

}

// Returns number of words in dictionary if loaded, else 0 if not yet loaded
unsigned int size(void)
{
    // TODO
    if (word_count > 0)
    {
        return word_count;
    }
    return 0;
}

// Unloads dictionary from memory, returning true if successful, else false
bool unload(void)
{
    // TODO
    // Iterate buckets in hash table
    for (int i = 0; i < N; i++)
    {
        // Move cursor to start of linked list, if curso != NULL, free memory
        node *cursor = table[i];

        while (cursor)
        {
            node *tmp = cursor;
            cursor = cursor->next;
            free(tmp);
        }
        // if cursor is NULL
        if (cursor == NULL)
        {
            return true;
        }
    }
    return false;
}
