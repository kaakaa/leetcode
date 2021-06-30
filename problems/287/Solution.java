// Runtime: 31 ms, faster than 6.97% of Java online submissions for Find the Duplicate Number.
// Memory Usage: 56.8 MB, less than 5.49% of Java online submissions for Find the Duplicate Number.
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return nums[i];
            }
        }
        throw new RuntimeException();
    }
}