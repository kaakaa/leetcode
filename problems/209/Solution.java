// Runtime: 1 ms, faster than 99.94% of Java online submissions for Minimum Size Subarray Sum.
// Memory Usage: 39.1 MB, less than 24.06% of Java online submissions for Minimum Size Subarray Sum.
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int prev = 0, next = 0, sum = 0, min = Integer.MAX_VALUE;

        int len = nums.length;
        while (next < len) {
            sum += nums[next];
            if (sum >= target) {
                while (sum >= target && prev <= next) {
                    if (min > next - prev + 1) {
                        min = next - prev + 1;
                    }
                    sum -= nums[prev++];
                }
            }
            // System.out.println(prev + ":" + next + " | " + sum + " | " + min);
            next++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}