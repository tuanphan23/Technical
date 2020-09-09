package DynamicPrograming;

import java.util.*;

/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
*/
public class GlobMatching {
    public static boolean GlobMatching(String text, String pattern) {
        int tLength = text.length();
        int pLength = pattern.length();
        boolean[][] matchTable = new boolean[tLength + 1][pLength + 1];

        for (int tIdx = 0; tIdx < tLength + 1; tIdx++) {
            for (int pIdx = 0; pIdx < pLength + 1; pIdx++) {

                // empty string
                if (tIdx == 0 && pIdx == 0) {
                    matchTable[tIdx][pIdx] = true;
                }

                // fill in first row
                else if (tIdx == 0) {
                    matchTable[tIdx][pIdx] = pattern.charAt(pIdx - 1) == '*' && matchTable[tIdx][pIdx - 1] == true;
                }

                // fil in first column
                else if (pIdx == 0) {
                    matchTable[tIdx][pIdx] = false;
                }

                // match char or '?'
                else if (pattern.charAt(pIdx - 1) == text.charAt(tIdx - 1) || pattern.charAt(pIdx - 1) == '?') {
                    matchTable[tIdx][pIdx] = matchTable[tIdx - 1][pIdx - 1];
                }

                // '*'
                else if (pattern.charAt(pIdx - 1) == '*') {
                    matchTable[tIdx][pIdx] = matchTable[tIdx - 1][pIdx] || matchTable[tIdx][pIdx - 1];
                }
            }
        }

        return matchTable[tLength][pLength];
    }

}