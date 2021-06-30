// Runtime: 4 ms, faster than 23.73% of Java online submissions for Max Area of Island.
// Memory Usage: 44.3 MB, less than 5.21% of Java online submissions for Max Area of Island.
class Solution {
    int colLen;
    int rowLen;
    public int maxAreaOfIsland(int[][] grid) {
        colLen = grid.length;
        rowLen = grid[0].length;
        int max = 0;
        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, trace(grid, i, j));
                }
            }
        }
        return max;
    }
    
    private int trace(int[][] grid, int i, int j) {
        int max = 1;
        grid[i][j] = 0;
        if (i > 0 && grid[i-1][j] == 1) {
            max += trace(grid, i-1, j);
        }
        if (i < colLen-1 && grid[i+1][j] == 1) {
            max += trace(grid, i+1, j);
        }
        if (j > 0 && grid[i][j-1] == 1) {
            max += trace(grid, i, j-1);
        }
        if (j < rowLen-1 && grid[i][j+1] == 1) {
            max += trace(grid, i, j+1);
        }
        return max;
    }
}