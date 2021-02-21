// Time Limit Exceed
class Solution {
    public int jump(int[] nums) {
        boolean[][] dp = new boolean[nums.length][nums.length];
        dp[0][0] = true;
        for (int i = 1; i <= nums[0]; i++) {
            if (i < nums.length) {
                dp[i][0] = true;
            }
        }
        h
        for (int i = 1; i < nums.length; i++) {
            dp[i][i] = true;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    dp[i+j][i] = true;
                }
            }
        }
        int count = 0;
        int goal = nums.length - 1;
        while (goal > 0) {
            System.out.println(goal);
            for (int i = 0; i < nums.length; i++) {
                if(dp[goal][i]) {
                    count++;
                    goal = i;
                    break;
                }
            }
        }
        return count;
    }
}