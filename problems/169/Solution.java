// Runtime: 3 ms, faster than 46.15% of Java online submissions for Majority Element.
// Memory Usage: 41.9 MB, less than 96.87% of Java online submissions for Majority Element.
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums[0];
        int count = 1;
        int l = nums.length;
        for (int i = 1; i < l; i++) {
            if (n != nums[i]) {
                n = nums[i];
                count = 1;
            } else {
                count++;
            }
            if (count > (l / 2)) {
                return n;
            }
        }
        return n;
    }
}