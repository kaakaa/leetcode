// Runtime: 18 ms, faster than 28.81% of Java online submissions for 01 Matrix.
// Memory Usage: 42.1 MB, less than 58.37% of Java online submissions for 01 Matrix.
class Solution {
    private final List<int[]> dirs = Arrays.asList(
        new int[]{-1,0},
        new int[]{1,0},
        new int[]{0,-1},
        new int[]{0,1}
    );
    public int[][] updateMatrix(int[][] mat) {
        int sizeX = mat.length;
        int sizeY = mat[0].length;
        
        int[][] ret = new int[sizeX][sizeY];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                } else {
                    ret[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            for (int[] dxdy : dirs) {
                int x = arr[0] + dxdy[0];
                int y = arr[1] + dxdy[1];
                if (0 <= x && x < sizeX) {
                    if (0 <= y && y < sizeY) {
                        if (ret[x][y] > ret[arr[0]][arr[1]] + 1) {
                            ret[x][y] = ret[arr[0]][arr[1]] + 1;
                            queue.offer(new int[]{x,y});
                        }
                    }
                }
            }
        }
        return ret;
    }
}