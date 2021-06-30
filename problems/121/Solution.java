// Runtime: 1 ms, faster than 98.84% of Java online submissions for Best Time to Buy and Sell Stock.
// Memory Usage: 52.3 MB, less than 30.51% of Java online submissions for Best Time to Buy and Sell Stock.
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int n = prices[i];
            if (min > n) {
                min = n;
                continue;
            }
            if (max < prices[i] - min) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}