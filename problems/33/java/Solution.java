// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
// Memory Usage: 38.3 MB, less than 76.46% of Java online submissions for Search in Rotated Sorted Array.
class Solution {
    public int search(int[] nums, int target) {
        int first = nums[0];
        int last = nums[nums.length - 1];

        if (target < first && last < target)
            return -1;
        if (first <= last) {
            if (target < first || last < target)
                return -1;
        }

        if (first == target)
            return 0;
        if (last == target)
            return nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}