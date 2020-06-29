package Strings;

import java.util.*;/*
                   Write a function that takes in a string and returns ít longest substring without duplicate characters.
                   */

public class LongestSubStringWithoutDuplication {
    public String longest(String str) {
        int startIdx = 0;
        int[] longest = { 0, 1 };
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (table.containsKey(str.charAt(i))) {
                startIdx = Math.max(startIdx, table.get(str.charAt(i)) + 1);
            }
            if (longest[1] - longest[0] < i + 1 - startIdx) {
                longest = new int[] { startIdx, i + 1 };
            }

            table.put(str.charAt(i), i);
        }
        return str.substring(longest[0], longest[1]);
    }
}