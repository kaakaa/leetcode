// Runtime: 2 ms, faster than 67.85% of Java online submissions for Jump Game II.
// Memory Usage: 41 MB, less than 76.66% of Java online submissions for Jump Game II.
class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int index = 0;
        int ret = 0;
        while (index < nums.length) {
            int max = 0;
            int j = 0;
            for (int i = 1; i <= nums[index]; i++) {
                if (index + i >= nums.length - 1) {
                    j = index + i;
                    break;
                }
                int reach = index + i + nums[index + i];
                if (max < reach) {
                    max = reach;
                    j = index + i;
                }
            }
            ret++;
            if (j >= nums.length - 1) {
                return ret;
            }
            index = j;
        }

        return ret;
    }
}