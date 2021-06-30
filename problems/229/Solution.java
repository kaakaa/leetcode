// Runtime: 2 ms, faster than 66.38% of Java online submissions for Majority Element II.
// Memory Usage: 42.8 MB, less than 58.44% of Java online submissions for Majority Element II.
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - (nums.length / 3); i++) {
            if (prev == nums[i]) {
                continue;
            }
            prev = nums[i];
            if (nums[i + nums.length / 3] == prev) {
                ret.add(prev);
                i += nums.length / 3;
            }
        }
        return ret;
    }
}