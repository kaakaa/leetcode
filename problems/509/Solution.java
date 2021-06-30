// Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
// Memory Usage: 37.2 MB, less than 5.00% of Java online submissions for Fibonacci Number.
class Solution {
    private int[] memo = new int[31];
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        if (memo[n] != 0) {
            return memo[n];
        }
        int N = fib(n-1) + fib(n-2);
        memo[n] = N;
        
        return N;
    }
}