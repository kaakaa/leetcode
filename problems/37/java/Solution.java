// Runtime: 18 ms, faster than 26.99% of Java online submissions for Sudoku Solver.
// Memory Usage: 36.5 MB, less than 55.79% of Java online submissions for Sudoku Solver.b
class Solution {
    public void solveSudoku(char[][] board) {
        backtracing(board);
    }

    private boolean backtracing(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (backtracing(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        int block = 3 * (i / 3) + (j / 3);
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c)
                return false;
            if (board[k][j] == c)
                return false;
            if (board[3 * (block / 3) + (k / 3)][3 * (block % 3) + (k % 3)] == c)
                return false;
        }
        return true;
    }

}