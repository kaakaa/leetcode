// Runtime: 1 ms, faster than 82.14% of Java online submissions for Happy Number.
// Memory Usage: 35.7 MB, less than 84.68% of Java online submissions for Happy Number.
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int m = n;
            int sum = 0;
            while (m > 0) {
                int d = m % 10;
                sum += d * d;
                m /= 10;
            }
            if (sum == 1) return true;
            if (set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
        return true;
    }
}