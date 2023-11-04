#include <cs50.h>
#include <stdio.h>

int get_cents(void);
int calculate_quarters(int cents);
int calculate_dimes(int cents);
int calculate_nickels(int cents);
int calculate_pennies(int cents);

int main(void)
{
    // Ask how many cents the customer is owed
    int cents;
    do
    {
        cents = get_int("Change owed: ");
    }
    while (cents < 0);

    // Calculate the number of quarters to give the customer
    int quarters;
    do
    {
        quarters = cents / 25;
        cents = cents - quarters * 25;
    }
    while (cents < 0);

    // Calculate the number of dimes to give the customer
    int dimes;
    do
    {
        dimes = cents / 10;
        cents = cents - dimes * 10;
    }
    while (cents < 0);

    // Calculate the number of nickels to give the customer
    int nickels;
    do
    {
        nickels = cents / 5;
        cents = cents - nickels * 5;
    }
    while (cents < 0);

    // Calculate the number of pennies to give the customer
    int pennies;
    do
    {
        pennies = cents / 1;
        cents = cents - pennies * 1;
    }
    while (cents < 0);

    // Sum coins
    int coins = quarters + dimes + nickels + pennies;

    // Print total number of coins to give the customer
    printf("%i\n", coins);
}

int get_cents(void)
{
    // Ask how many cents the customer is owed
    int cents;
    do
    {
        cents = get_int("Change owed: ");
    }
    while (cents < 0);
    return cents;
}

int calculate_quarters(int cents)
{
    // Calculate the number of quarters to give the customer
    int quarters;
    do
    {
        quarters = cents / 25;
        cents = cents - quarters * 25;
    }
    while (cents < 0);
    return quarters;
}

int calculate_dimes(int cents)
{
    // Calculate the number of dimes to give the customer
    int dimes;
    do
    {
        dimes = cents / 10;
        cents = cents - dimes * 10;
    }
    while (cents < 0);
    return dimes;
}

int calculate_nickels(int cents)
{
    // Calculate the number of nickels to give the customer
    int nickels;
    do
    {
        nickels = cents / 5;
        cents = cents - nickels * 5;
    }
    while (cents < 0);
    return nickels;
}

int calculate_pennies(int cents)
{
    // Calculate the number of pennies to give the customer
    int pennies;
    do
    {
        pennies = cents / 1;
        cents = cents - pennies * 1;
    }
    while (cents < 0);
    return pennies;
}
