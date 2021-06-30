// Runtime: 1 ms, faster than 93.81% of Java online submissions for Unique Binary Search Trees II.
// Memory Usage: 39.6 MB, less than 66.64% of Java online submissions for Unique Binary Search Trees II.
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateSubTrees(n, 0);
    }

    private List<TreeNode> generateSubTrees(int n, int add) {
        if (n == 1) {
            return Arrays.asList(new TreeNode(add + 1));
        }
        List<TreeNode> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int n1 = i - 1;
            int add1 = add;
            List<TreeNode> lefts = generateSubTrees(n1, add1);

            int n2 = n - i;
            int add2 = add + i;
            List<TreeNode> rights = generateSubTrees(n2, add2);

            if (lefts.isEmpty()) {
                for (TreeNode r : rights) {
                    ret.add(new TreeNode(i + add, null, r));
                }
            } else {
                for (TreeNode l : lefts) {
                    if (rights.isEmpty()) {
                        ret.add(new TreeNode(i + add, l, null));
                        continue;
                    }
                    for (TreeNode r : rights) {
                        ret.add(new TreeNode(i + add, l, r));
                    }
                }
            }
        }
        return ret;
    }
}