// Runtime: 1 ms, faster than 99.96% of Java online submissions for Sqrt(x).
// Memory Usage: 35.7 MB, less than 95.68% of Java online submissions for Sqrt(x).
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        long l = 1, r = x;
        while (l < r) {
            long m = l + (r-l)/2;
            if (m == l || m == r) return (int)m;
            if (m*m == x) return (int)m;
            if (m*m < x) l = m;
            else r = m;
        }
        if (r*r == x) return (int)r;
        return (int)l;
    }
}