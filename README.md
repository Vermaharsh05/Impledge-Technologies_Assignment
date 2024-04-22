# Using a HashSet to store the words read from the input files ensuring efficient identification of compound words.
# Using DFS to recursively check if a word can be split into smaller words found in the HashSet can help determine if it is a compound word.
# Sorting the words based on length can optimize the search for compound words, especially when dealing with large word lists.
# This program works by first creating a set of all the unique words in the given set. Then, it iterates over the set and checks if each word is a compound word.To check if a word is a compound word, the program splits the word into all possible pairs of prefixes and suffixes. If both the prefix and the suffix are in the set of words, then the word is a compound word.
# The program keeps track of the longest compound word it finds. At the end of the program, it prints the longest and second longest compound word to the console.
# To measure the time taken to process the input files, I used System.currentTimeMillis() to capture the current time before and after the processing and calculate the difference.
