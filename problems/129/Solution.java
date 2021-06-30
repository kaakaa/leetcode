// Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
// Memory Usage: 36.7 MB, less than 45.11% of Java online submissions for Sum Root to Leaf Numbers.
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return dig(root, 0);
    }

    private int dig(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }

        num = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            return num;
        }
        return dig(node.left, num) + dig(node.right, num);
    }
}