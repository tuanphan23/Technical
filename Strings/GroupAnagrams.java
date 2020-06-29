package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
An anagram is a sequence of characters formed by rearranging the letters of another full sequence of characters.
Given a list of words words, return a list of lists with each word in words grouped with its other anagrams.
*/

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> output = new HashMap<>();

        for (String word : words) {
            String sortedWord = sort(word);

            List<String> anagramList = output.getOrDefault(sortedWord, new ArrayList<>());
            anagramList.add(word);
            output.put(sortedWord, anagramList);
        }

        return new ArrayList<>(output.values());
    }

    private String sort(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}