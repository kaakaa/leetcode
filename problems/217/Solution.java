// Runtime: 3 ms, faster than 99.67% of Java online submissions for Contains Duplicate.
// Memory Usage: 42.3 MB, less than 86.49% of Java online submissions for Contains Duplicate.
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return true;
        }
        return false;
    }
}