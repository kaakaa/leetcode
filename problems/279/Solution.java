// Runtime: 95 ms, faster than 26.73% of Java online submissions for Perfect Squares.
// Memory Usage: 138.1 MB, less than 5.06% of Java online submissions for Perfect Squares.
class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(n));
        int step = 0;
        while (!q.isEmpty()) {
            step++;
            for (int i = q.size(); i > 0; i--) {
                int target = q.poll();
                for (int j = (int) Math.sqrt(n); j > 0; j--) {
                    int p = (int) Math.pow(j, 2.0);
                    if (p == target) {
                        return step;
                    }
                    if (p < target) {
                        q.offer(target - p);
                    }
                }
            }
        }
        return -1;
    }
}