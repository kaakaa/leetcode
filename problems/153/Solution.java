// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
// Memory Usage: 38.9 MB, less than 8.34% of Java online submissions for Find Minimum in Rotated Sorted Array.
class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (min > n)
                min = n;
        }
        return min;
    }
}
