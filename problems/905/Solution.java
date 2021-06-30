// Runtime: 1 ms, faster than 98.33% of Java online submissions for Sort Array By Parity.
// Memory Usage: 39.3 MB, less than 97.97% of Java online submissions for Sort Array By Parity.
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums;
        
        int slow = 0;
        while (slow < len && nums[slow] % 2 == 0) { slow++; }
        if (slow == len) return nums;
        int fast = slow+1;
        while (fast < len) {
            if (nums[fast] % 2 == 0) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}