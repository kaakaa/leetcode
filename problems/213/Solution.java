// Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
// Memory Usage: 36.4 MB, less than 50.48% of Java online submissions for House Robber II.
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (len == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        int[] dp1 = new int[len];
        dp1[0] = nums[0];
        dp1[1] = nums[1];
        dp1[2] = nums[0] + nums[2];

        int[] dp2 = new int[len];
        dp2[0] = 0;
        dp2[1] = nums[1];
        dp2[2] = nums[2];

        for (int i = 3; i < len; i++) {
            int n = nums[i];
            dp1[i] = Math.max(dp1[i - 3], dp1[i - 2]) + n;
            dp2[i] = Math.max(dp2[i - 3], dp2[i - 2]) + n;
        }

        if (nums[0] < nums[len - 1]) {
            dp1[len - 1] -= nums[0];
        } else {
            dp1[len - 1] -= nums[len - 1];
        }
        return Math.max(Math.max(dp1[len - 2], dp1[len - 1]), Math.max(dp2[len - 2], dp2[len - 1]));
    }
}