// Runtime: 2 ms, faster than 28.65% of Java online submissions for Trapping Rain Water.
// Memory Usage: 38.5 MB, less than 75.63% of Java online submissions for Trapping Rain Water.
class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int ret = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                ret += distance * boundedHeight;
            }
            stack.push(i);
        }
        return ret;
    }
}