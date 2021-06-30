// Runtime: 194 ms, faster than 32.78% of Java online submissions for The Skyline Problem.
// Memory Usage: 42.1 MB, less than 60.93% of Java online submissions for The Skyline Problem.
// refs: https://kennyzhuang.gitbooks.io/algorithms-collection/content/the_skyline_problem.html
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
        pq.offer(0);
        
        int prev = 0;
        List<List<Integer>> ret = new ArrayList<>();
        
        for (int[] h : height) {
            // System.out.println(Arrays.toString(h));
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            
            if (prev != cur) {
                ret.add(Arrays.asList(h[0], cur));
                prev = cur;
            }
        }
        return ret;
    }
}