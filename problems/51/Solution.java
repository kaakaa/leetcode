// Runtime: 13 ms, faster than 12.16% of Java online submissions for N-Queens.
// Memory Usage: 43.8 MB, less than 5.39% of Java online submissions for N-Queens.
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrack(ret, board, n, 0);
        return ret;
    }

    private void backtrack(List<List<String>> ret, boolean[][] board, int n, int row) {
        if (row >= n) {
            List<String> list = new ArrayList<>();
            for (boolean[] arr : board) {
                list.add(
                    IntStream
                        .range(0, arr.length)
                        .mapToObj(i -> arr[i])
                        .map(b -> b ? "Q" : ".")
                        .collect(Collectors.joining()));
            }
            ret.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            board[row][i] = true;
            if (isNotUnderAttack(board, n, row, i)) {
                backtrack(ret, board, n, row+1);
            }
            board[row][i] = false;
        }
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