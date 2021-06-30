// Runtime: 460 ms, faster than 34.75% of Java online submissions for Target Sum.
// Memory Usage: 36.5 MB, less than 72.16% of Java online submissions for Target Sum.
class Solution {
    private int ret;
    public int findTargetSumWays(int[] nums, int target) {
        this.ret = 0;
        recursion(nums, target, 0, 0);
        return this.ret;
    }
    
    private void recursion(int[] nums, int target, int sum, int idx) {
        if (idx == nums.length) {
            if (sum == target) this.ret++;
            return;
        } 
        recursion(nums, target, sum + nums[idx], idx+1);
        recursion(nums, target, sum - nums[idx], idx+1);
    }
}