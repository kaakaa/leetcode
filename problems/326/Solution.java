// Runtime: 11 ms, faster than 59.07% of Java online submissions for Power of Three.
// Memory Usage: 38.4 MB, less than 90.85% of Java online submissions for Power of Three.
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (Math.abs(n) != 3) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}