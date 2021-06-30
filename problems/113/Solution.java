// Runtime: 2 ms, faster than 35.52% of Java online submissions for Path Sum II.
// Memory Usage: 42.1 MB, less than 8.89% of Java online submissions for Path Sum II.
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        recursive(ret, new ArrayList<>(), root, targetSum);
        return ret;
    }

    private void recursive(List<List<Integer>> ret, List<Integer> tmp, TreeNode node, int sum) {
        int i = sum - node.val;
        tmp.add(node.val);

        if (node.left == null && node.right == null) {
            if (i == 0) {
                ret.add(tmp);
            }
            return;
        }
        if (node.left != null) {
            recursive(ret, new ArrayList<>(tmp), node.left, i);
        }
        if (node.right != null) {
            recursive(ret, new ArrayList<>(tmp), node.right, i);
        }
    }
}