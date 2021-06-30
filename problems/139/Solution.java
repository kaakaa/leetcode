// Runtime: 2 ms, faster than 93.04% of Java online submissions for Word Break.
// Memory Usage: 39 MB, less than 74.19% of Java online submissions for Word Break.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int l = w.length();
                if (i >= l && w.equals(s.substring(i - l, i)) && dp[i - l]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}