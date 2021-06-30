// Runtime: 1 ms, faster than 100.00% of Java online submissions for Max Consecutive Ones.
// Memory Usage: 40.1 MB, less than 76.20% of Java online submissions for Max Consecutive Ones.
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (max < count) max = count;
                count = 0;
            }
        }
        if (max < count) return count;
        return max;
    }
}