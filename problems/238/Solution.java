// Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
// Memory Usage: 47.4 MB, less than 98.07% of Java online submissions for Product of Array Except Self.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (hasZero) {
                    prod = 0;
                    break;
                } else {
                    hasZero = true;
                    continue;
                }
            }
            prod *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (hasZero) {
                nums[i] = nums[i] == 0 ? prod : 0;
            } else {
                nums[i] = nums[i] == 0 ? 0 : prod / nums[i];
            }
        }
        return nums;
    }
}