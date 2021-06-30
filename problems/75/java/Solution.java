// Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
// Memory Usage: 37.1 MB, less than 97.26% of Java online submissions for Sort Colors.
class Solution {
    public void sortColors(int[] nums) {
        int idx = 0;
        int zero = 0;
        int two = nums.length - 1;
        while (idx <= two) {
            // System.out.println(Arrays.toString(nums));
            switch (nums[idx]) {
                case 0:
                    if (idx != zero) {
                        swap(nums, zero++, idx);
                        continue;
                    }
                    zero++;
                    break;
                case 1:
                    break;
                case 2:
                    if (idx != two) {
                        swap(nums, two--, idx);
                        continue;
                    }
                    two--;
            }
            idx++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
}