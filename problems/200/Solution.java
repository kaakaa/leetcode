// Runtime: 1 ms, faster than 100.00% of Java online submissions for Number of Islands.
// Memory Usage: 41.2 MB, less than 81.75% of Java online submissions for Number of Islands.
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                switch (grid[i][j]) {
                case '1':
                    check(grid, i, j);
                    count++;
                    break;
                default:
                }
            }
        }
        return count;
    }

    public void check(char[][] grid, int i, int j) {
        grid[i][j] = '2';
        if (i > 0 && grid[i - 1][j] == '1') {
            check(grid, i - 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            check(grid, i, j - 1);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            check(grid, i + 1, j);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
            check(grid, i, j + 1);
        }
    }
}