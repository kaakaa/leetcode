// Runtime: 5 ms, faster than 59.01% of Java online submissions for Best Time to Buy and Sell Stock III.
// Memory Usage: 53.5 MB, less than 73.80% of Java online submissions for Best Time to Buy and Sell Stock III.
// refs: https://bohenan.gitbooks.io/leetcode/content/123-best-time-to-buy-and-sell-stock-iii.html
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;

        int[] left = new int[n];
        int min = prices[0];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        int[] right = new int[n];
        int max = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);

            profit = Math.max(profit, left[i] + right[i]);
        }

        return profit;
    }
}