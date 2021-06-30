// Runtime: 1 ms, faster than 84.86% of Java online submissions for Binary Tree Level Order Traversal II.
// Memory Usage: 38.9 MB, less than 89.71% of Java online submissions for Binary Tree Level Order Traversal II.
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        recursive(ret, queue);
        return ret;
    }

    private void recursive(List<List<Integer>> ret, Queue<TreeNode> queue) {
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            temp.add(node.val);
            if (node.left != null) {
                nextQueue.offer(node.left);
            }
            if (node.right != null) {
                nextQueue.offer(node.right);
            }
        }

        if (temp.isEmpty()) {
            return;
        }
        ret.add(0, temp);

        if (nextQueue.isEmpty()) {
            return;
        }
        recursive(ret, nextQueue);
    }
}