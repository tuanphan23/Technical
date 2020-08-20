package HashTable;

import java.util.*;
/*
Given a string s, find the length of the longest substring that contains at most k distinct characters.
*/

public class LongestSubstringWithKCharacters {
    public int LongestSubstringWithKCharacters(String s, int k) {
        Map<Character, Integer> SMap = new HashMap<Character, Integer>();
        int length = 0;
        int counter = k;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (!SMap.containsKey(rightChar))
                counter--;
            int count = SMap.getOrDefault(rightChar, 0);
            SMap.put(rightChar, count + 1);
            while (counter < 0) {
                char leftChar = s.charAt(left);
                SMap.put(leftChar, SMap.get(leftChar) - 1);
                if (SMap.get(leftChar) == 0)
                    counter++;
                left++;
            }
            length = Math.max(right - left + 1, length);
            right++;
        }

        return length;
    }
}