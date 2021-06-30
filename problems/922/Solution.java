// Runtime: 3 ms, faster than 37.09% of Java online submissions for Sort Array By Parity II.
// Memory Usage: 39.8 MB, less than 90.39% of Java online submissions for Sort Array By Parity II.
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int slow = 0, fast = 1;
        while (fast < len) {
            if (slow >= fast) fast = slow + 1;
            if (slow % 2 == nums[slow] % 2) {
                slow++;
                continue;
            }
            
            int odd = slow % 2;
            while (fast < len && odd != nums[fast] % 2) { fast++; }
            if (fast == len) break;
            int swap = nums[slow];
            nums[slow] = nums[fast];
            nums[fast] = swap;
            slow++;
        }
        return nums;
    }
}