// Runtime: 1 ms, faster than 80.07% of Java online submissions for Height Checker.
// Memory Usage: 36.6 MB, less than 57.53% of Java online submissions for Height Checker.
class Solution {
    public int heightChecker(int[] heights) {
        int[] ordered = Arrays.copyOf(heights, heights.length);
        Arrays.sort(ordered);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != ordered[i]) count++;
        }
        return count;
    }
}