// Runtime: 1 ms, faster than 76.84% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
// Memory Usage: 39 MB, less than 63.99% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        zigzag(ret, queue, 1);
        return ret;
    }

    private void zigzag(List<List<Integer>> ret, LinkedList<TreeNode> queue, int level) {
        List<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> nextQueue = new LinkedList<>();
        if (level % 2 == 1) {
            while (!queue.isEmpty()) {
                TreeNode n = queue.pollFirst();
                if (n == null) {
                    continue;
                }
                temp.add(n.val);
                nextQueue.offerLast(n.left);
                nextQueue.offerLast(n.right);
            }
        } else {
            while (!queue.isEmpty()) {
                TreeNode n = queue.pollLast();
                if (n == null) {
                    continue;
                }
                temp.add(n.val);
                nextQueue.offerFirst(n.right);
                nextQueue.offerFirst(n.left);
            }
        }
        if (temp.size() == 0) {
            return;
        }
        ret.add(temp);
        zigzag(ret, nextQueue, level + 1);
    }

}