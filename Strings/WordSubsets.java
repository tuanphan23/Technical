package Strings;

import java.util.ArrayList;
import java.util.List;

/*
Given 2 sequences of strings A and B, determine all of the "universal" characters in A relative to B. 
Return the list of these universal characters.
A string a in A is "universal" relative to B if for each string in B (we will name b) a is a superset of b. 
This means that a has all of the characters in each b (ignoring order) in quantity at least.
*/
public class WordSubsets {
    public List<String> wordSubsets(List<String> A, List<String> B) {
        List<String> output = new ArrayList<>();
        int[] bCount = new int[26];
        for (String word : B) {
            int[] tempCount = count(word);

            for (int i = 0; i < 26; i++) {
                bCount[i] = Math.max(tempCount[i], bCount[i]);
            }
        }

        for (String word : A) {
            int[] tempCount = count(word);
            boolean isSubset = true;
            for (int i = 0; i < 26; i++) {
                if (tempCount[i] < bCount[i]) {
                    isSubset = false;
                }
            }
            if (isSubset) {
                output.add(word);
            }
        }
        return output;
    }

    private int[] count(String word) {
        int[] count = new int[26];

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            count[index] += 1;
        }

        return count;
    }
}