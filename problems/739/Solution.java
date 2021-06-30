// Runtime: 14 ms, faster than 72.40% of Java online submissions for Daily Temperatures.
// Memory Usage: 47.3 MB, less than 32.83% of Java online submissions for Daily Temperatures.
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        if (len == 0) {
            return null;
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[len];
        stack.push(0);
        for (int i = 1; i < len; i++) {
            int n = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < n) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        for (Integer i : stack) {
            ret[i] = 0;
        }
        return ret;
    }
}