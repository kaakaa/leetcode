// Runtime: 1 ms, faster than 43.11% of Java online submissions for First Missing Positive.
// Memory Usage: 36.7 MB, less than 74.75% of Java online submissions for First Missing Positive.
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
            if (index == nums[i]) {
                index++;
            }
        }
        return index;
    }
}
