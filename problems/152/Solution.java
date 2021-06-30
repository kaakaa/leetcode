// Runtime: 2 ms, faster than 25.41% of Java online submissions for Maximum Product Subarray.
// Memory Usage: 39.1 MB, less than 18.94% of Java online submissions for Maximum Product Subarray.
// refs: https://programmerstart.com/article/4583836235/
class Solution {
    public int maxProduct(int[] nums) {
        int[] plusMax = new int[nums.length];
        int[] minusMin = new int[nums.length];

        plusMax[0] = nums[0];
        minusMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            plusMax[i] = Math.max(Math.max(plusMax[i - 1] * n, minusMin[i - 1] * n), n);
            minusMin[i] = Math.min(Math.min(plusMax[i - 1] * n, minusMin[i - 1] * n), n);
            max = Math.max(Math.max(plusMax[i], minusMin[i]), max);
        }
        return max;
    }
}