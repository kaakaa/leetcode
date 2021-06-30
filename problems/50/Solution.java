// Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
// Memory Usage: 37 MB, less than 96.40% of Java online submissions for Pow(x, n).
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            if (n % 2 == 0) return 1;
            return -1;
        }

        double ret = x;
        if (n < 0) {
            n *= -1;
            return 1.0 / pow(x, n);
        }
        return pow(x, n);
    }
    
    private double pow(double x, int n) {
        if (n == 0) return 1.0;
        double y = pow(x, n / 2);
        if (n%2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }
}