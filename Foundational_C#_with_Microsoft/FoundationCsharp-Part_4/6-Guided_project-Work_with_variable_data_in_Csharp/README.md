The design specification

For the new features of the Contoso Pets application, the design specification provides details for the dog search and suggested donation features:

    Dog attribute search
        Gather input for the pet characteristic search term
        Loop through the animals array and identify "dogs"
        For each dog, combine the physical and personality descriptions to search
        Search the combined description for the input term match
        Output the dogs that have a term match

    Suggested donation data
        Define suggestedDonation string
        Expand the ourAnimals array to contain suggestedDonation and populate sample data for suggestedDonation
        Ensure all usage of ourAnimals array accounts for the added suggestedDonation data
        Output suggestedDonation with regional currency symbol ($, €, ¥,... )
