// Runtime: 14 ms, faster than 41.25% of Java online submissions for Longest Consecutive Sequence.
// Memory Usage: 58.8 MB, less than 7.18% of Java online submissions for Longest Consecutive Sequence.
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        int max = 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 0) continue;
            if (nums[i] - nums[i-1] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }
}