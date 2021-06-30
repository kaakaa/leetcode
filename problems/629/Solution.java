// Runtime: 60 ms, faster than 31.50% of Java online submissions for K Inverse Pairs Array.
// Memory Usage: 60.6 MB, less than 5.51% of Java online submissions for K Inverse Pairs Array.
// refs: https://dreamume.medium.com/leetcode-629-k-inverse-pairs-array-8f6b1c05e3ea
class Solution {
    public int kInversePairs(int n, int k) {
        if (k > n * (n-1) / 2 || k < 0) return 0;
        long[][] dp = new long[1024][1024];
        int mod = 1000000007;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            if (i+1 <= n) dp[i+1][0] = 1;
            for (int j = 1; j <= Math.min(k, i*(i-1)/2); j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                if (j >= i) dp[i][j] -= dp[i-1][j-i];
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return (int)dp[n][k];
    }
}