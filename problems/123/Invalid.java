class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] before = new int[n];
        int[] dp = new int[n];
        int max = 0;
        int beforeMax = 0;
        for (int i = 0; i < n; i++) {
            int swap = beforeMax;
            for (int j = i + 1; j < n; j++) {
                int m = prices[j] - prices[i];
                if (m < 0) {
                    m = 0;
                }
                before[j] = before[j] < m ? m : before[j];
                if (i + 1 == j && beforeMax < before[j]) {
                    beforeMax = before[j];
                }

                dp[j] = dp[j] < m + swap ? m + swap : dp[j];
                if (max < dp[j]) {
                    max = dp[j];
                }
            }
        }
        return max;
    }
}