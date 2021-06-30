// Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
// Memory Usage: 35.4 MB, less than 95.40% of Java online submissions for Unique Binary Search Trees.
class Solution {
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return generateSubTrees(n, 0);
    }

    private int generateSubTrees(int n, int add) {
        if (n == 1) {
            memo[n][add] = 1;
            return 1;
        }

        int ret = 0;
        for (int i = 1; i <= n; i++) {
            int n1 = i - 1;
            int add1 = add;

            int left = memo[n1][add1];
            if (n1 != 0 && left == 0) {
                left = generateSubTrees(n1, add1);
            }

            int n2 = n - i;
            int add2 = add + i;
            int right = memo[n2][add2];
            if (n2 != 0 && right == 0) {
                right = generateSubTrees(n2, add2);
            }
            if (left == 0) {
                ret += right;
            } else if (right == 0) {
                ret += left;
            } else {
                ret += left * right;
            }
        }
        memo[n][add] = ret;
        return ret;
    }
}