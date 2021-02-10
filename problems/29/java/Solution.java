// Runtime: 1846 ms, faster than 7.87% of Java online submissions for Divide Two Integers.
// Memory Usage: 36.4 MB, less than 26.07% of Java online submissions for Divide Two Integers.
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            } else {
                return 0;
            }
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        boolean isPos1 = dividend < 0 ? false : true;
        boolean isPos2 = divisor < 0 ? false : true;

        int adder = 1;
        if ((isPos1 && !isPos2) || (!isPos1 && isPos2)) {
            adder = -1;
        }

        boolean isMinValue = dividend == Integer.MIN_VALUE ? true : false;

        if (isMinValue) {
            dividend = Math.abs(++dividend);
        } else {
            dividend = Math.abs(dividend);
        }
        divisor = Math.abs(divisor);

        int ret = 0;
        while (dividend >= divisor) {
            ret += adder;
            dividend -= divisor;
            if (isMinValue) {
                dividend++;
                isMinValue = false;
            }
        }
        return ret;
    }
}