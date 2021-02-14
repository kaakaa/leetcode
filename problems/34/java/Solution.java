// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
// Memory Usage: 43.9 MB, less than 11.53% of Java online submissions for Find First and Last Position of Element in Sorted Array.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[] { 0, 0 };
            } else {
                return new int[] { -1, -1 };
            }
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            // System.out.println(i + ":" + j);
            int dest = (j + i) / 2;
            if (nums[dest] == target) {
                return findRange(nums, dest);
            } else if (target < nums[dest]) {
                if (j == dest) {
                    j--;
                } else {
                    j = dest;
                }
            } else {
                if (i == dest) {
                    i++;
                } else {
                    i = dest;
                }
            }
        }
        return new int[] { -1, -1 };
    }

    private int[] findRange(int[] nums, int dest) {
        int i = dest - 1, j = dest + 1;
        while (i >= 0 && nums[i] == nums[dest]) {
            i--;
        }
        while (j < nums.length && nums[j] == nums[dest]) {
            j++;
        }

        return new int[] { i + 1, j - 1 };
    }
}