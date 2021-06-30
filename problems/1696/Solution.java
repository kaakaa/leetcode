// Runtime: 1827 ms, faster than 5.06% of Java online submissions for Jump Game VI.
// Memory Usage: 53.6 MB, less than 80.59% of Java online submissions for Jump Game VI.
class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        int m = dp[0];
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            int n = dp[idx] + nums[i];
            if (m < n) {
                m = n;
                idx = i;
            }
            dp[i] = n;
            if (i-idx >= k) {
                int newIdx = idx+1;
                int max = dp[newIdx];
                for (int j = 2; j <= k; j++) {
                    if (max < dp[idx+j]) {
                        max = dp[idx+j];
                        newIdx = idx+j;
                    }
                }
                idx = newIdx;
            }
            // System.out.println(Arrays.toString(dp) + " / " + idx);
        }
        return dp[nums.length-1];
    }
}