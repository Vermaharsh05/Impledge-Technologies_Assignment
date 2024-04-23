package Assignment;

import java.io.*;
import java.util.*;

public class CompoundWordFinder {
    public static void main(String[] args) throws FileNotFoundException {

        long startTime = System.currentTimeMillis();
        List<String> list = new ArrayList<>();

        try {
            File file = new File("Input_01.txt");
           // File file = new File("Input_02.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String longestword = "";
        String secondLongestWord = "";

        for (String word : list) {
            if (isCompoundWord(word, list)) {
                if (word.length() > longestword.length()) {
                    secondLongestWord = longestword;
                    longestword = word;
                } else if (word.length() > secondLongestWord.length()) {
                    secondLongestWord = word;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        System.out.println("Longest Compound Word: " + longestword);
        System.out.println("Second Longest Compound Word: " + secondLongestWord);
        System.out.println("Time taken to process file: " + timeTaken + " milliseconds");

    }
    public static boolean startsWith(String str, String prefix) {
        if (str == null || prefix == null || prefix.isEmpty()) {
            return false;
        }

        if (str.length() < prefix.length()) {
            return false;
        }

        for (int i = 0; i < prefix.length(); i++) {
            if (str.charAt(i) != prefix.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isCompoundWord(String word, List<String> wordsList) {
        for (String wordPart : wordsList) {
            if (wordPart.length() < word.length() && startsWith(word,wordPart)) {
                String suffix = word.substring(wordPart.length());
                if (wordsList.contains(suffix) || isCompoundWord(suffix, wordsList)) {
                    return true;
                }
            }
        }
        return false;
    }
}
