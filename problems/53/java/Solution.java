// Runtime: 1 ms, faster than 53.34% of Java online submissions for Maximum Subarray.
// Memory Usage: 39 MB, less than 58.18% of Java online submissions for Maximum Subarray.
class Solution {
    public int maxSubArray(int[] nums) {
        int base = Integer.MIN_VALUE;
        int max = 0;
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // System.out.println(nums[i] + " / " + base + " : " + max + " : " + ret);
            if (base != 0 && base < nums[i]) {
                base = nums[i] > 0 ? 0 : nums[i];
                if (ret < base) {
                    ret = base;
                }
            }

            if (base != 0) {
                continue;
            }

            int tmp = max + nums[i];
            if (nums[i] < 0) {
                max = tmp < 0 ? 0 : tmp;
            } else {
                max = tmp;
                if (ret < max) {
                    ret = max;
                }
            }
        }
        return max > 0 && ret < max ? max : ret;
    }
}