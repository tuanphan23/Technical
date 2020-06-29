package Strings;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s and an integer value rows return the "zigzag" encoding of s read off row-by-row.
*/

public class ZigzagConvestion {
    public String zigzag(String s, int rows) {

        List<String> output = new ArrayList(rows);

        for (int i = 0; i < rows; i++) {
            output.add("");
        }

        int row = 0;
        boolean down = false;

        for (char c : s.toCharArray()) {
            output.set(row, output.get(row) + c);

            if (row == 0 || row == rows - 1) {
                down = !down;
            }

            if (rows > 1) {
                if (down)
                    row++;
                else
                    row--;
            }
        }

        StringBuilder result = new StringBuilder();

        for (String rowString : output) {
            result.append(rowString);
        }

        return result.toString();
    }
}