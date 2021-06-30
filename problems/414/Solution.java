// Runtime: 1 ms, faster than 87.03% of Java online submissions for Third Maximum Number.
// Memory Usage: 39.1 MB, less than 12.55% of Java online submissions for Third Maximum Number.
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 3) return nums[len-1];
        int unique = 1;
        for (int i = len-1; i > 0; i--) {
            if (nums[i] != nums[i-1]) unique++;
            if (unique == 3) return nums[i-1];
        }
        return nums[len-1];
    }
}