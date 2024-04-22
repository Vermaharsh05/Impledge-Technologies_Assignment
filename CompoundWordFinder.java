package Assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CompoundWordFinder {

    private static Set<String> wordSet = new HashSet<>();

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        // readInputFile("Input_01.txt");
        readInputFile("Input_02.txt");

        String longestCompoundWord = findLongestCompoundWord();
        String secondLongestCompoundWord = findSecondLongestCompoundWord();

        System.out.println("Longest Compound Word: " + longestCompoundWord);
        System.out.println("Second Longest Compound Word: " + secondLongestCompoundWord);

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken to process file: " + timeTaken + " milliseconds");
    }
    private static void readInputFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordSet.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static boolean isCompoundWord(String word) {
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (wordSet.contains(prefix)) {
                String suffix = word.substring(i);
                if (wordSet.contains(suffix) || isCompoundWord(suffix)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static String findLongestCompoundWord() {
        String longestWord = "";
        for (String word : wordSet) {
            if (isCompoundWord(word) && word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
    private static String findSecondLongestCompoundWord() {
        String longestWord = findLongestCompoundWord();
        String secondLongestWord = "";
        for (String word : wordSet) {
            if (isCompoundWord(word) && !word.equals(longestWord) && word.length() > secondLongestWord.length()) {
                secondLongestWord = word;
            }
        }
        return secondLongestWord;
    }
}

