// Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
// Memory Usage: 36.2 MB, less than 80.15% of Java online submissions for Same Tree.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(p);
        Queue<TreeNode> qq = new LinkedList<>();
        qq.offer(q);
        
        while(!pq.isEmpty() && !qq.isEmpty()) {
            TreeNode pn = pq.poll();
            TreeNode qn = qq.poll();
            if (pn == null && qn == null) continue;
            if (pn == null || qn == null) return false;
            if (pn.val != qn.val) return false;
            pq.offer(pn.left);
            pq.offer(pn.right);
            qq.offer(qn.left);
            qq.offer(qn.right);
        }
        return true;
    }
}