// Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
// Memory Usage: 36.3 MB, less than 48.89% of Java online submissions for House Robber.
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        return dp[len - 1] > dp[len - 2] ? dp[len - 1] : dp[len - 2];
    }
}