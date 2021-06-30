// Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
// Memory Usage: 36.5 MB, less than 24.46% of Java online submissions for Invert Binary Tree.
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node.left != null) {
            invert(node.left);
        }
        if (node.right != null) {
            invert(node.right);
        }
        TreeNode swap = node.left;
        node.left = node.right;
        node.right = swap;
    }
}