// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
// Memory Usage: 38.5 MB, less than 71.39% of Java online submissions for Find Peak Element.
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < nums[mid+1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}