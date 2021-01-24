class Solution {
    public int maxArea(int[] height) {
        int maxValue = 0;
        int maxBase = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (maxBase < height[i]) {
                maxBase = height[i];
            } else {
                continue;
            }
            for (int j = i + 1; j < height.length; j++) {
                int h = height[i] < height[j] ? height[i] : height[j];
                int w = j - i;
                int v = h * w;
                if (maxValue < v) {
                    maxValue = v;
                }
            }
        }
        return maxValue;
    }
}