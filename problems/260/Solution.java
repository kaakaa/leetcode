// Runtime: 2 ms, faster than 45.56% of Java online submissions for Single Number III.
// Memory Usage: 39.1 MB, less than 59.47% of Java online submissions for Single Number III.
class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        boolean first = false;
        int[] ret = new int[2];
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                if (!first) {
                    ret[0] = nums[i--];
                    first = true;
                    continue;
                } else {
                    ret[1] = nums[i];
                    return ret;
                }
            }
        }

        ret[1] = nums[nums.length - 1];
        return ret;
    }
}