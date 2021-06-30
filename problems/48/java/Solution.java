// Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
// Memory Usage: 39.3 MB, less than 24.20% of Java online submissions for Rotate Image.
class Solution {
    public void rotate(int[][] matrix) {
        int i = 0;
        while (i < matrix.length / 2) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int swap1 = matrix[j][matrix.length - 1 - i];
                int swap2 = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                int swap3 = matrix[matrix.length - 1 - j][i];

                matrix[j][matrix.length - 1 - i] = matrix[i][j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = swap1;
                matrix[matrix.length - 1 - j][i] = swap2;
                matrix[i][j] = swap3;
            }
            i++;
        }
    }
}