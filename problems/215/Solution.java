// Runtime: 1 ms, faster than 97.72% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 38.9 MB, less than 96.41% of Java online submissions for Kth Largest Element in an Array.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
