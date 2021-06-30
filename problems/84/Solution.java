// Runtime: 88 ms, faster than 6.36% of Java online submissions for Largest Rectangle in Histogram.
// Memory Usage: 118.6 MB, less than 5.20% of Java online submissions for Largest Rectangle in Histogram.
class Solution {
    public int largestRectangleArea(int[] heights) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, heights.length-1});
        
        int max = 0;
        while (!queue.isEmpty()) {
            int[] range = queue.poll();
            if (range[0] > range[1]) continue;
            
            List<Integer> indexes = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for (int i = range[0]; i <= range[1]; i++) {
                int n = heights[i];
                if (min > n) {
                    min = n;
                    indexes = new ArrayList<>();
                    indexes.add(i);
                } else if (min == n) {
                    indexes.add(i);
                }
            }
            max = Math.max(max, min * (range[1] - range[0] + 1));
            int nextStart = range[0];
            for (int i : indexes) {
                queue.offer(new int[]{nextStart, i-1});
                nextStart = i+1;
            }
            queue.offer(new int[]{nextStart, range[1]});
            // System.out.println(range[0] + ":" + range[1] + " / " + min * (range[1] - range[0] + 1) + " - " + queue.size());
        }
        
        return max;
    }
}