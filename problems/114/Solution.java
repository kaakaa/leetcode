// Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
// Memory Usage: 38.1 MB, less than 91.29% of Java online submissions for Flatten Binary Tree to Linked List.
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        connect(root);
    }

    private TreeNode connect(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode right = root.right;
        TreeNode last = null;
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            last = connect(root.right);
            last.right = right;
            if (right != null) {
                last = connect(right);
            }
        } else {
            if (right != null) {
                last = connect(right);
            }
        }
        return last;
    }
}