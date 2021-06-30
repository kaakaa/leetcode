// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array II.
// Memory Usage: 39.1 MB, less than 54.52% of Java online submissions for Remove Duplicates from Sorted Array II.
class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] == nums[i]) {
                if (count++ >= 2) continue;
            } else {
                count = 1;
            }
            nums[++idx] = nums[i];
        }
        return idx + 1;
    }
}