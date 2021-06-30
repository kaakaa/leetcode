// Runtime: 8 ms, faster than 20.78% of Java online submissions for Search a 2D Matrix II.
// Memory Usage: 51.9 MB, less than 5.69% of Java online submissions for Search a 2D Matrix II.
class Solution {
    int xLen, yLen;
    public boolean searchMatrix(int[][] matrix, int target) {
        return dc(matrix, target, 0, 0, matrix.length-1, matrix[0].length-1);
    }
    
    private boolean dc(int[][] matrix, int target, int sx, int sy, int ex, int ey) {
        if (matrix[sx][sy] > target) return false;
        if (matrix[ex][ey] < target) return false;
        if (ex-sx <= 1 && ey-sy <= 1) {
            if (
                matrix[sx][sy] == target
                || matrix[sx][ey] == target
                || matrix[ex][sy] == target
                || matrix[ex][ey] == target
            )
                return true;
            return false;
        }
        
        int px = sx + (ex-sx)/2;
        int py = sy + (ey-sy)/2;
        int pivot = matrix[px][py];
        
        if (pivot == target) return true;
        
        if (dc(matrix, target, px, sy, ex, py)
            || dc(matrix, target, sx, py, px, ey))
            return true;
        
        if (pivot < target) {
            return dc(matrix, target, px, py, ex, ey);
        } else {
            return dc(matrix, target, sx, sy, px, py);
        }
    }
}