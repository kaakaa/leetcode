// Runtime: 16 ms, faster than 30.96% of Java online submissions for Find All Numbers Disappeared in an Array.
// Memory Usage: 47.9 MB, less than 56.57% of Java online submissions for Find All Numbers Disappeared in an Array.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i < nums[0]; i++) {
            ret.add(i);
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] >= 2) {
                for (int j = 1; j < nums[i] - nums[i-1]; j++) {
                    ret.add(nums[i-1] + j);
                }
            }
        }
        for (int i = nums[nums.length-1] + 1; i <= nums.length; i++) {
            ret.add(i);
        }
        return ret;
    }
}