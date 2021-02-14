// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
// Memory Usage: 40 MB, less than 17.20% of Java online submissions for Search Insert Position.
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] == target) {
                j--;
            }
            return j + 1;
        }

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            System.out.println(i + ":" + j);
            int dest = (i + j) / 2;
            if (nums[dest] == target) {
                while (dest >= 0 && nums[dest] == target) {
                    dest--;
                }
                return dest + 1;
            } else if (target < nums[dest]) {
                j = j == dest ? j - 1 : dest;
            } else {
                i = i == dest ? i + 1 : dest;
            }
        }
        return i;
    }
}