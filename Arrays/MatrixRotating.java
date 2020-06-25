package Arrays;

/*
Given a two-dimensional square matrix (n x n), rotate the matrix 90 degrees to the right (clockwise). 
*/

public class MatrixRotating {
    public int[][] rotate(int[][] matrix) {
        int lastIndex = matrix.length - 1;

        for (int layer = 0; layer < matrix.length / 2; layer++) {
            for (int i = layer; i < lastIndex - layer; i++) {
                int top = matrix[layer][i];
                int right = matrix[i][lastIndex - layer];
                int bottom = matrix[lastIndex - layer][lastIndex - i];
                int left = matrix[lastIndex - i][layer];

                matrix[layer][i] = left;
                matrix[i][lastIndex - layer] = top;
                matrix[lastIndex - layer][lastIndex - i] = right;
                matrix[lastIndex - i][layer] = bottom;
            }
        }

        return matrix;
    }
}