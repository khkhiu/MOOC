#include "helpers.h"
#include <math.h>

// Convert image to grayscale
// Reusing parts of my 'smiley' code
void grayscale(int height, int width, RGBTRIPLE image[height][width])
{
    // Command to change height
    for (int H = 0; H < height; H++)
    {
        // Command to change width
        for (int W = 0; W < width; W++)
        {
            //take the average of the red, green, and blue values to determine what shade of grey to make the new pixel.
            int rgb_2_g = round((image[H][W].rgbtRed + image[H][W].rgbtGreen + image[H][W].rgbtBlue) / 3.0);
            //make sure the red, green, and blue values are all the same value.
            image[H][W].rgbtRed = image[H][W].rgbtGreen = image[H][W].rgbtBlue = rgb_2_g;
        }
    }
    return;
}

// Convert image to sepia
void sepia(int height, int width, RGBTRIPLE image[height][width])
{
    // Command to change height
    for (int H = 0; H < height; H++)
    {
        // Command to change width
        for (int W = 0; W < width; W++)
        {
            // Formula from problem statement
            int sepiaRed = round(.393 * image[H][W].rgbtRed + .769 * image[H][W].rgbtGreen + .189 * image[H][W].rgbtBlue);
            int sepiaGreen = round(.349 * image[H][W].rgbtRed + .686 * image[H][W].rgbtGreen + .168 * image[H][W].rgbtBlue);
            int sepiaBlue = round(.272 * image[H][W].rgbtRed + .534 * image[H][W].rgbtGreen + .131 * image[H][W].rgbtBlue);

            // Capping RGB values at 255
            if (sepiaRed > 255)
            {
                image[H][W].rgbtRed = 255;
            }
            else
            {
                image[H][W].rgbtRed = sepiaRed;
            }

            if (sepiaGreen > 255)
            {
                image[H][W].rgbtGreen = 255;
            }
            else
            {
                image[H][W].rgbtGreen = sepiaGreen;
            }

            if (sepiaBlue > 255)
            {
                image[H][W].rgbtBlue = 255;
            }
            else
            {
                image[H][W].rgbtBlue = sepiaBlue;
            }
            /*
            Alt code using ternary operators
            Using ternary operators
            syntax == exp1 ? exp2 : exp3
            if exp1 is true, exp2 runs
            if exp1 is false, exp3 runs

            image[H][W].rgbtBlue = (sepiaBlue > 255) ? 255 : sepiaBlue;
            image[H][W].rgbtGreen = (sepiaGreen > 255) ? 255 : sepiaGreen;
            image[H][W].rgbtRed = (sepiaRed > 255) ? 255 : sepiaRed;
            */
        }
    }
    return;
}

// Reflect image horizontally
// Swap horizontal pixels, while leaving vertical pixels unchanged
void reflect(int height, int width, RGBTRIPLE image[height][width])
{
    // Command to change height
    for (int H = 0; H < height; H++)
    {
        // Command to change width, (width/2) is needed to prevent pixel loss when iterating through the image
        for (int W = 0; W < (width / 2); W++)
        {
            // Use temporary var to store original image
            // RGBTRIPLE allows us to configure Red, Green, Blue at the same time
            RGBTRIPLE img_temp = image[H][W];
            // Set current pixels to pixel on the opposites side of the image
            // Store pixels on the right into original image
            image[H][W] = image[H][width - W - 1];
            // Set reflected pixel to original pixel
            // Store right image into temporary var
            image[H][width - W - 1] = img_temp;
        }
    }
    return;
}

// Blur image
void blur(int height, int width, RGBTRIPLE image[height][width])
{
    // Create temporary array using RGBTRIPLE to implement blur FX
    RGBTRIPLE img_temp[height][width];
    // Loop through height and width of pixel to create a temporary image
    for (int H = 0; H < height; H++)
    {
        for (int W = 0; W < width; W++)
        {
            img_temp[H][W] = image[H][W];
        }
    }

    // Blur FX begins here
    for (int H = 0; H < height; H++)
    {
        for (int W = 0; W < width; W++)
        {
            // Initialise new variables to store values of surrouding pixels
            // float type is used, otherwise Blur FX will fail a few checks
            float T_Red, T_Green, T_Blue;
            T_Red = T_Green = T_Blue = 0;
            // counter var to count the number of surrouding pixels
            int counter = 0;

            // Loop vertical pixels
            for (int V = -1; V < 2; V++)
            {
                // Loop horizontal pixels, using D for diameter
                for (int D = -1; D < 2; D++)
                {
                    // Check if pixel is outside range of 0 and height
                    if (H + V < 0 || H + V >= height)
                    {
                        continue;
                    }
                    // Check if pixel is outside range of 0 and width
                    if (W + D < 0 || W + D >= width)
                    {
                        continue;
                    }
                    // Add value of pixels if it is within height and width
                    T_Red += img_temp[H + V][W + D].rgbtRed;
                    T_Blue += img_temp[H + V][W + D].rgbtBlue;
                    T_Green += img_temp[H + V][W + D].rgbtGreen;
                    counter++;
                }
            }

            // Get average of RGB values
            image[H][W].rgbtRed = round(T_Red / counter);
            image[H][W].rgbtGreen = round(T_Green / counter);
            image[H][W].rgbtBlue = round(T_Blue / counter);
        }
    }
    return;
}