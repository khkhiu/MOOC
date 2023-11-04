#include "helpers.h"

void colorize(int height, int width, RGBTRIPLE image[height][width])
{
    // Change all black pixels to a color of your choosing
    // Command to change height
    for (int elevation = 0; elevation < height; elevation++)
    {
        // Command to change width
        for (int diameter = 0; diameter < width; diameter++)
        {
            if
            (   //If colour = black, change to different color
                image[elevation][diameter].rgbtRed == 0 &&
                image[elevation][diameter].rgbtGreen == 0 &&
                image[elevation][diameter].rgbtBlue == 0
            )
            {
                image[elevation][diameter].rgbtRed = 255;
                image[elevation][diameter].rgbtGreen = 87;
                image[elevation][diameter].rgbtBlue = 51;
            }
        }
    }
}
