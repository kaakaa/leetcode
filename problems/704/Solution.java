// Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
// Memory Usage: 39.8 MB, less than 58.55% of Java online submissions for Binary Search.
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        if (left == right) return -1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (mid == left || mid == right) return -1;
            int n = nums[mid];
            if (n == target) {
                return mid;
            } else if (n < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}