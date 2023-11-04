#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

typedef uint8_t BYTE;

int main(int argc, char *argv[])
{
    // Ensure that progamme only runs with 1 argc
    if (argc != 2)
    {
        printf("Usage: ./recover IMAGE");
        return 1;
    }
    else
    {
        // Open raw file
        char *input_file_name = argv[1];
        FILE *input_pointer = fopen(input_file_name, "r");

        if (input_pointer == NULL)
        {
            printf("Error: cannot open %s\n", input_file_name);
            return 2;
        }
        else
        {
            // set array to 512 bytes, allowing all bytes to be read at the same time
            BYTE buffer[512];
            // covers the number of images recoverred
            int img_recovered = 0;
            // pointer to file to be written to
            FILE *img_pointer = NULL;
            // store name of imgs generated
            char file_name[8];

            // Recovery FX starts here
            // fread explanation here -> https://www.tutorialspoint.com/c_standard_library/c_function_fread.htm
            /*
            While loop OPS
            1. Reads values from input_pointer and writes them to buffer with 512 bytes
            2. Returns number of sucessfully read elements
            3. if sucessfully read elements != 1, end of file reached, terminate loop
            */
            while (fread(&buffer, 512, 1, input_pointer) == 1)
            {
                // check for start of new JPEG
                if (buffer[0] == 0xff && buffer[1] == 0xd8 && buffer[2] == 0xff && (buffer[3] & 0xf0) == 0xe0)
                {
                    // After writting 512 bytes to buffer, check for new JPEG
                    // If new JPEG present, close previous JPEG
                    if (!(img_recovered == 0))
                    {
                        fclose(img_pointer);
                    }

                    // sprintf to name new JPEG
                    sprintf(file_name, "%03i.jpg", img_recovered);
                    img_pointer = fopen(file_name, "w");
                    // increment number of JPEG countered
                    img_recovered++;
                }
                // If new JPEG foud, write 512 byte block, using referenced stored in img_pointer
                if (!(img_recovered == 0))
                {
                    fwrite(&buffer, 512, 1, img_pointer);
                }
            }
            //Close all currently open files after input file is read through
            fclose(input_pointer);
            fclose(img_pointer);
            return 0;
        }
    }

}