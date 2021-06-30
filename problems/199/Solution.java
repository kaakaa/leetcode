// Runtime: 1 ms, faster than 73.01% of Java online submissions for Binary Tree Right Side View.
// Memory Usage: 37.5 MB, less than 67.74% of Java online submissions for Binary Tree Right Side View.
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        ret.add(root.val);
        LinkedList<TreeNode> next = new LinkedList<>();
        if (root.left != null)
            next.offerLast(root.left);
        if (root.right != null)
            next.offerLast(root.right);

        recursive(next, ret);

        return ret;
    }

    private void recursive(LinkedList<TreeNode> nodes, List<Integer> ret) {
        if (nodes.isEmpty()) {
            return;
        }

        ret.add(nodes.peekLast().val);

        LinkedList<TreeNode> next = new LinkedList<>();
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pollFirst();
            if (node.left != null)
                next.offerLast(node.left);
            if (node.right != null)
                next.offerLast(node.right);
        }
        recursive(next, ret);
    }
}