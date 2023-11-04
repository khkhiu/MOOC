import csv
import sys


def main():

    # TODO: Check for command-line usage
    # Do not accept cmd-line input if not 3
    if len(sys.argv) != 3:
        print("Usage: python dna.py data.csv sequence.txt")
        sys.exit(1)

    # TODO: Read data file into a variable
    # initiate "data" list to var from csv file
    data = []
    with open(sys.argv[1], 'r') as file:
        reader = csv.DictReader(file)
        for row in reader:
            data.append(row)

    # TODO: Read DNA sequence file into a variable
    with open(sys.argv[2], 'r') as file:
        dna_sequence = file.read()
    # DNA sequence to check
    sequence_check = list(data[0].keys())[1:]

    # TODO: Find longest match of each STR in DNA sequence
    # initiate "longest_match_result" to save output of longes_match FX
    # Counting each dna_sequence in "data" from lines 15 to 23
    # initiate result to save all seqeunce count
    longest_match_result = {}
    for subsequence in sequence_check:
        longest_match_result[subsequence] = longest_match(dna_sequence, subsequence)

    # TODO: Check data for matching profiles
    # check "longest_match_result" values against values in "data"
    for person in data:
        match = 0
        for subsequence in sequence_check:
            if int(person[subsequence]) == longest_match_result[subsequence]:
                match = match + 1

        # If all sequence_check matched
        if match == len(sequence_check):
            print(person["name"])
            return


print("No match")
return


def longest_match(sequence, subsequence):
    """Returns length of longest run of subsequence in sequence."""

    # Initialize variables
    longest_run = 0
    subsequence_length = len(subsequence)
    sequence_length = len(sequence)

    # Check each character in sequence for most consecutive runs of subsequence
    for i in range(sequence_length):

        # Initialize count of consecutive runs
        count = 0

        # Check for a subsequence match in a "substring" (a subset of characters) within sequence
        # If a match, move substring to next potential match in sequence
        # Continue moving substring and checking for matches until out of consecutive matches
        while True:

            # Adjust substring start and end
            start = i + count * subsequence_length
            end = start + subsequence_length

            # If there is a match in the substring
            if sequence[start:end] == subsequence:
                count += 1

            # If there is no match in the substring
            else:
                break

        # Update most consecutive matches found
        longest_run = max(longest_run, count)

    # After checking for runs at each character in seqeuence, return longest run found
    return longest_run


main()
