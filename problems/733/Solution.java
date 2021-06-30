// Runtime: 24 ms, faster than 14.98% of Java online submissions for Flood Fill.
// Memory Usage: 40.5 MB, less than 5.56% of Java online submissions for Flood Fill.
class Solution {
    private final List<int[]> neighbors = Arrays.asList(
        new int[]{-1,0},
        new int[]{1,0},
        new int[]{0,-1},
        new int[]{0,1}
    );
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] p = new int[]{ sr, sc };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(p);
        Set<String> visited = new HashSet<>();
        
        int color = image[sr][sc];
        int sizeX = image.length;
        int sizeY = image[0].length;
        
        while (!queue.isEmpty()) {
            p = queue.poll();
            visited.add(String.format("%d:%d", p[0], p[1]));
            image[p[0]][p[1]] = newColor;
            for (int[] dxdy : neighbors) {
                int x = p[0] + dxdy[0];
                int y = p[1] + dxdy[1];
                if (
                    (0 <= x && x < sizeX) &&
                    (0 <= y && y < sizeY) &&
                    !visited.contains(String.format("%d:%d", x, y)) &&
                    image[x][y] == color
                ) {
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return image;
    }
}