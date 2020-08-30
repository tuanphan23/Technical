package DynamicPrograming;

import java.util.*;

/*
Write a function that takes in two strings and returns number of edit operations that need to be performed on the first string to obtain the second string.
*/

public class levenshteinDistance {
    public static int levenshteinDistance(String str1, String str2) {
        int ET[][] = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                ET[0][j] = j;
            }
            ET[i][0] = i;
        }

        for (int r = 1; r < str1.length() + 1; r++) {
            for (int c = 1; c < str2.length() + 1; c++) {
                if (str1.charAt(r - 1) == str2.charAt(c - 1)) {
                    ET[r][c] = ET[r - 1][c - 1];
                } else {
                    ET[r][c] = Math.min(ET[r][c - 1], Math.min(ET[r - 1][c - 1], ET[r - 1][c])) + 1;
                }
            }
        }

        return ET[str1.length()][str2.length()];
    }
}