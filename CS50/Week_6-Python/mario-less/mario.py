# importing get_int from cs50
from cs50 import get_int


# FX for getting the height and draw the platform
# See here for documentation: https://www.w3schools.com/python/python_functions.asp
def main():
    height = get_height()
    draw(height, height)


# Get height if user inputs a value between 1 and 8
def get_height():
    while True:
        try:
            height = get_int("Height: ")
            if (height > 0 and height < 9):
                break
        except ValueError:
            None
    return height


# Drawing of the platform according to stated requirements
def draw(height, i):
    if height == 0:
        return
    draw(height - 1, i)
    print(" " * (i - height), end='')
    print("#" * height)


# FX call to actually address the problem set
main()