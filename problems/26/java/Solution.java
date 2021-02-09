// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
// Memory Usage: 40.7 MB, less than 70.64% of Java online submissions for Remove Duplicates from Sorted Array.
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] != nums[i]) {
                idx++;
                nums[idx] = nums[i];
            }
        }
        nums = Arrays.copyOf(nums, idx + 1);
        return nums.length;
    }
}