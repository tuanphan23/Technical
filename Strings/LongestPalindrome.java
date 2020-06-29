package Strings;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a string, determine the length of the longest possible palindromic string 
that can be constructed using the characters of the string. 
*/

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int length = 0;

        Set<Character> matching = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (matching.contains(c)) {
                matching.remove(c);
                length++;
            } else {
                matching.add(c);
            }
        }

        length *= 2;

        if (!matching.isEmpty())
            length++;

        return length;
    }
}