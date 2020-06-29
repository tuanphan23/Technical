package Strings;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of strings words and a string pattern return a list of all of the strings in words 
that matches the pattern of the pattern string.
*/
public class PatternMatching {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> output = new ArrayList<>();

        for (String word : words)
            isMatch(word, pattern);

        return output;
    }

    // helper function to check word match to pattern
    private boolean isMatch(String word, String pattern) {
        if(word.length() != pattern.length()) return false;

        int[] wordToPattern = new int[256];
        int[] patternToWord = new int[256];

        for(int i = 0; i < word.length(); i++) {
            int wordChar = Character.getNumericValue(word.charAt(i));
            int patternChar = Character.getNumericValue(pattern.charAt(i));

            if(wordToPattern[wordChar] == 0)
                wordToPattern[wordChar] = patternChar;
            
            if(patternToWord[patternChar] == 0)
                patternToWord[patternChar] = wordChar;

            if(wordToPattern[wordChar] != patternChar || patternToWord[patternChar] != wordChar)
                return false;
        }
    }return false;
}