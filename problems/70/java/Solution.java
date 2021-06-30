// Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
// Memory Usage: 35.5 MB, less than 91.67% of Java online submissions for Climbing Stairs.
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] stack = new int[n + 1];
        stack[1] = 1;
        stack[2] = 2;
        for (int i = 3; i <= n; i++) {
            stack[i] = stack[i - 2] + stack[i - 1];
        }
        return stack[n];
    }
}