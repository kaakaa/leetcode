// Runtime: 2 ms, faster than 13.21% of Java online submissions for Find Numbers with Even Number of Digits.
// Memory Usage: 38.6 MB, less than 42.22% of Java online submissions for Find Numbers with Even Number of Digits.
class Solution {
    public int findNumbers(int[] nums) {
        return Math.toIntExact(
            Arrays
            .stream(nums)
            .filter(n -> (10 <= n && n <= 99) || (1000 <= n && n <= 9999) || n == 100000)
            .count()
        );
    }
}