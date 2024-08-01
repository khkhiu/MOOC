Project specification overview

Update the existing Contoso Pets starter application to include multiple term search and improved "search status" animation features:
Add dog attribute multi-term search

Gather user input for the pet characteristic multiple term search

    Users need to provide search terms separated by commas
    Store the search terms in an array and sort the terms alphabetically

Within the animals array loop that identifies "dogs":

    Iterate through the search terms to search each dog's description
    Search the combined description for a term match
    Output each dog's description where there's one or more terms matched

After exiting the "search Animals" array loop that identifies dogs:

    If no dogs were a match for any of the users provided search terms, output a no dogs matched message.

Add "search status" improvements

Update the animation

    Adjust the searchingIcons array to resemble a spinning dial
    Adjust the animation loop so the animation shows a numeric countdown from two to zero (2.., 1.., 0..)
