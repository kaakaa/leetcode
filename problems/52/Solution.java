// Runtime: 2 ms, faster than 65.29% of Java online submissions for N-Queens II.
// Memory Usage: 37.6 MB, less than 37.49% of Java online submissions for N-Queens II.
class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return backtrack(0, board, n, 0);
    }

    private int backtrack(int count, boolean[][] board, int n, int row) {
        if (row >= n) {
            return count + 1;
        }
        for (int i = 0; i < n; i++) {
            board[row][i] = true;
            if (isNotUnderAttack(board, n, row, i)) {
                count = backtrack(count, board, n, row+1);
            }
            board[row][i] = false;
        }
        return count;
    }
    
    private boolean isNotUnderAttack(boolean[][] board, int n, int row, int col) {
        for (int i = 1; i <= row; i++) {
            if (board[row-i][col]) return false;
            if (col-i >= 0 && board[row-i][col-i]) return false;
            if (col+i < n && board[row-i][col+i]) return false;
        }
        return true;
    }
}