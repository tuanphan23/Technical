package HashTable;

import java.util.*;
/*
Given a string corpus and a string target, find the minimum window (substring) which contain all the characters that are found in target.

The time complexity of the solution should be in order of O(n).


NOTE: substring and  sub-sequence are different things
*/

public class MinimumWindowSubstring {

    /*
     * Brute Force Method Time complexity: O(n^2) Space complexity: O(k)
     */
    public String minWindow(String searchString, String t) {

        int minWindowLength = Integer.MAX_VALUE;
        String minWindow = "";

        for (int left = 0; left < searchString.length(); left++) {
            Map<Character, Integer> requriedCharaters = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++) {
                int count = requriedCharaters.getOrDefault(t.charAt(i), 0);
                requriedCharaters.put(t.charAt(i), count + 1);
            }
            int counter = requriedCharaters.size();
            for (int right = left; right < searchString.length(); right++) {
                char currrentChar = searchString.charAt(right);
                if (requriedCharaters.containsKey(currrentChar)) {
                    requriedCharaters.remove(currrentChar);
                    counter--;
                }
                if (counter == 0 && (right - left + 1) < minWindowLength) {
                    minWindowLength = (right - left + 1);
                    minWindow = searchString.substring(left, right + 1);
                }
            }
        }

        return minWindow;
    }
    /*
     * Sliding window method Time Complexity: O(n) Space Complexity: O(k)
     */

    public String minWindow2(String searchString, String target) {
        Map<Character, Integer> requiredCharacters = new HashMap<Character, Integer>();
        for (int i = 0; i < target.length(); i++) {
            int count = requiredCharacters.getOrDefault(target.charAt(i), 0);
            requiredCharacters.put(target.charAt(i), count + 1);
        }
        int counter = requiredCharacters.size();
        String minWindow = "";
        int minWindowLength = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < searchString.length(); right++) {
            char currentRightChar = searchString.charAt(right);
            if (requiredCharacters.containsKey(currentRightChar)) {
                requiredCharacters.put(currentRightChar, requiredCharacters.get(currentRightChar) - 1);
                if (requiredCharacters.get(currentRightChar) == 0)
                    counter--;
            }
            while (counter == 0) {
                if ((right - left) < minWindowLength) {
                    minWindowLength = right - left;
                    minWindow = searchString.substring(left, right++);
                }
                char currentLeftChar = searchString.charAt(left);
                if (requiredCharacters.containsKey(currentLeftChar)) {
                    requiredCharacters.put(currentLeftChar, requiredCharacters.get(currentLeftChar) + 1);
                    if (requiredCharacters.get(currentLeftChar) > 0)
                        counter++;
                }
                left++;
            }
        }

        return minWindow;
    }

}