# import get_float
from cs50 import get_float

# FX for calculating change owed
def main():
    owed = get_owed()
    coins = calc_coins(owed)
    print(f"{coins}")

# FX for user input
def get_owed():
    while True:
        try:
            owed = get_float("Change owed: ")
            if owed > 0:
                break
        except ValueError:
            None

    return owed


# FX for calculating change
def calc_coins(change):
    # Round value to integer
    value = round(change * 100)

    # Quarter = 25 cents
    quarters = int(value / 25)
    less_quarters = int(value % 25)

    # Dime = 10 cents
    dimes = int(less_quarters / 10)
    less_dimes = int(less_quarters % 10)

    # Nickel = 5 cents
    nickels = int(less_dimes / 5)
    less_nickels = int(less_dimes % 5)

    # Penny = 1 cent
    pennies = int(less_nickels % 5)

    # calculate total coins
    coins = quarters + dimes + nickels + pennies

    return coins


main()

