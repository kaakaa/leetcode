// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
// Memory Usage: 37.5 MB, less than 68.37% of Java online submissions for Remove Element.
class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        nums = Arrays.copyOf(nums, idx);
        return nums.length;
    }
}