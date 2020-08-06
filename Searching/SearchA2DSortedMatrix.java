package Searching;

import java.util.*;

/*
Given a 2D matrix (which is m x n) find the given element with value value. 
If the matrix contains the value return true, otherwise return false.
*/

public class SearchA2DSortedMatrix {
    /*
     * Variant 1: In this variant, all values in the matrix are increasing in
     * row-major order.
     * 
     * This means that: Each row is sorted The last element in row i is <= the first
     * element in row i+1 By virtue of the previous two properties, the columns are
     * sorted
     */
    public boolean search(int[][] matrix, int target) {
        int left = 0;
        int totalRow = matrix.length;
        int totalCol = matrix[0].length;
        int right = totalRow * totalCol - 1;

        while (left < right) {
            int middle = left + (right + left) / 2;
            int middleValue = matrix[middle / totalCol][middle % totalCol];
            if (target == middleValue)
                return true;
            else if (target < middleValue)
                right = middle - 1;
            else
                left = middle + 1;
        }

        return false;
    }

    /*
     * Variant 2: In this variant: Each row is sorted Each column is sorted There is
     * no guarantee that the last element in row i is <= the first element in row
     * i+1
     */

    public boolean search2(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row <= matrix.length - 1 && col >= 0) {
            if (target == matrix[row][col])
                return true;
            else if (target > matrix[row][col])
                col--;
            else
                row++;
        }
        return false;
    }
}