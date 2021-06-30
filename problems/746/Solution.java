// Runtime: 1 ms, faster than 80.16% of Java online submissions for Min Cost Climbing Stairs.
// Memory Usage: 40.5 MB, less than 8.21% of Java online submissions for Min Cost Climbing Stairs.
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            int c = cost[i];
            dp[i] = Math.min(c+dp[i-1], c+dp[i-2]);
        }
        return Math.min(dp[len-1], dp[len-2]);
    }
}