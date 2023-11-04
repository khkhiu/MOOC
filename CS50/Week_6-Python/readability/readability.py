from cs50 import get_string

text = get_string("Text: ")

# Main FX
def main():

    letter = count_letters(text)
    word = count_words(text)
    sentence = count_sentences(text)
    index = calc_index(letter, word, sentence)

    if index >= 1 and index <= 16:
        print("Grade ", index)
    elif index > 16:
        print("Grade 16+")
    else:
        print("Before Grade 1")

# Count number of letters present
def count_letters(string):
    letter_count = 0
    for i in string:
        # Count number of letter present
        if (i.isalpha()) == True:
            letter_count += 1
    return letter_count

# Count number of words present
def count_words(string):
    word_count = 0
    for i in string:
        # count number of spaces, allowing the counting of numbers of words
        if (i.isspace()) == True:
            word_count += 1
    return word_count + 1

# Count number of sentences present
def count_sentences(string):
    sentence_count = 0
    for i in string:
        # count punctuation to count number os sentences
        if i == '?' or i == '.' or i == '!':
            sentence_count += 1
    return sentence_count

# Calculating readability index
def calc_index(letter, word, sentence):
    avg_letter = letter * 100 / word
    avg_sentence = sentence * 100 / word
    read_index = (0.0588 * avg_letter) - (0.296 * avg_sentence) - 15.8
    return round(read_index)

# Call main FX
main()