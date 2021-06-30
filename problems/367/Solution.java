// Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
// Memory Usage: 35.7 MB, less than 48.39% of Java online submissions for Valid Perfect Square.
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 1, right = num;
        while (left < right) {
            int mid = left + (right-left)/2;
            int n = num/mid;
            if (mid == num/mid && num % mid == 0) {
                return true;
            }
            if (n < mid) right = mid - 1;
            else left = mid + 1;
        }
        return left*left == num;
    }
}