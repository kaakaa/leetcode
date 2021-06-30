// Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
// Memory Usage: 38.8 MB, less than 43.06% of Java online submissions for Convert Sorted Array to Binary Search Tree.
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int idx = nums.length / 2;
        TreeNode node = new TreeNode(nums[idx]);
        if (idx > 0) {
            node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, idx));
        }
        if (idx < nums.length) {
            node.right = sortedArrayToBST(Arrays.copyOfRange(nums, idx + 1, nums.length));
        }
        return node;
    }
}