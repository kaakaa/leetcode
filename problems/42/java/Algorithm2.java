// Runtime: 1 ms, faster than 85.69% of Java online submissions for Trapping Rain Water.
// Memory Usage: 38.6 MB, less than 64.00% of Java online submissions for Trapping Rain Water.
class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            ret += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ret;
    }
}