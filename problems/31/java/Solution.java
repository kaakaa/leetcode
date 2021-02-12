// Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
// Memory Usage: 39 MB, less than 76.63% of Java online submissions for Next Permutation.
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int base = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                base = i;
                break;
            }
        }
        if (base == -1) {
            Arrays.sort(nums);
            return;
        }
        int target = nums.length - 1;
        while (target > base && nums[target] <= nums[base]) {
            target--;
        }
        // System.out.println(target + ":" + base);
        int swap = nums[base];
        nums[base] = nums[target];
        nums[target] = swap;

        int i = base + 1;
        int j = nums.length - 1;
        while (i < j) {
            swap = nums[i];
            nums[i] = nums[j];
            nums[j] = swap;
            i++;
            j--;
        }
    }
}
