// Runtime: 174 ms, faster than 5.05% of Java online submissions for Maximum Performance of a Team.
// Memory Usage: 115.9 MB, less than 5.05% of Java online submissions for Maximum Performance of a Team.
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Pair<Integer, Integer>> candidates = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            candidates.add(new Pair<>(efficiency[i], speed[i]));
        }
        Collections.sort(candidates, Comparator.comparing(o -> -o.getKey()));
        
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        long speedSum = 0, max = 0;
        for (Pair<Integer, Integer> p : candidates) {
            if (speedHeap.size() > k - 1) {
                speedSum -= speedHeap.remove();
            }
            int s = p.getValue();
            speedHeap.add(s);
            speedSum += s;
            max = Math.max(max, speedSum * p.getKey());
        }
        return (int) (max % 1000000007);
    }
}