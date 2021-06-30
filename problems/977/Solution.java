// Runtime: 3 ms, faster than 29.32% of Java online submissions for Squares of a Sorted Array.
// Memory Usage: 40.5 MB, less than 78.93% of Java online submissions for Squares of a Sorted Array.
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}