// Runtime: 59 ms, faster than 22.59% of Java online submissions for Maximum Erasure Value.
// Memory Usage: 52.5 MB, less than 43.74% of Java online submissions for Maximum Erasure Value.
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0, sum = 0, len = nums.length;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int n = nums[i];
            while (set.contains(n)) {
                int j = queue.poll();
                sum -= j;
                set.remove(j);
            }
            
            queue.offer(n);
            set.add(n);
            sum += n;
            max = Math.max(max, sum);
        }
        return max;
    }
}