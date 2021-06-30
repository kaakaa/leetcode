// Runtime: 9 ms, faster than 12.37% of Java online submissions for Maximal Square.
// Memory Usage: 42.3 MB, less than 42.48% of Java online submissions for Maximal Square.
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                max = Math.max(max, check(matrix, i, j, 1));
            }
        }
        return max * max;
    }

    private int check(char[][] matrix, int i, int j, int size) {
        if (i + size >= matrix.length || j + size >= matrix[0].length) {
            return size;
        }
        for (int k = 0; k < size; k++) {
            if (matrix[i + k][j + size] != '1' || matrix[i + size][j + k] != '1') {
                return size;
            }
        }
        if (matrix[i + size][j + size] != '1') {
            return size;
        }

        size = check(matrix, i, j, ++size);

        return size;
    }
}
