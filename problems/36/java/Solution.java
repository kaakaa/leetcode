// Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Sudoku.
// Memory Usage: 38.7 MB, less than 92.46% of Java online submissions for Valid Sudoku.
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] col = new int[9];
        int[] row = new int[9];
        int[] block = new int[9];
        for (int i = 0; i < 9; i++) {
            col[i] = 0;
            row[i] = 0;
            block[i] = 0;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int n = Character.getNumericValue(board[i][j]);
                    if ((col[i] & 1 << n) != 0) {
                        return false;
                    }
                    if ((row[j] & 1 << n) != 0) {
                        return false;
                    }
                    int bIndex = getBlockIndex(i, j);
                    if ((block[bIndex] & 1 << n) != 0) {
                        return false;
                    }
                    col[i] = col[i] | 0x01 << n;
                    row[j] = row[j] | 0x01 << n;
                    block[bIndex] = block[bIndex] | 0x01 << n;
                }
            }
        }
        return true;
    }

    private int getBlockIndex(int i, int j) {
        return 3 * (i / 3) + (j / 3);
    }
}