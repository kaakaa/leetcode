// Runtime: 7 ms, faster than 60.85% of Java online submissions for Binary Tree Paths.
// Memory Usage: 38.9 MB, less than 80.92% of Java online submissions for Binary Tree Paths.
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        List<List<String>> all = track(list, root);
        return all.stream().map(l -> l.stream().collect(Collectors.joining("->"))).collect(Collectors.toList());
    }

    private List<List<String>> track(List<String> list, TreeNode node) {
        List<List<String>> ret = new ArrayList<>();
        list.add(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
            ret.add(list);
            return ret;
        }
        if (node.left != null) {
            List<String> temp = new ArrayList<>(list);
            ret.addAll(track(temp, node.left));
        }
        if (node.right != null) {
            List<String> temp = new ArrayList<>(list);
            ret.addAll(track(temp, node.right));
        }
        return ret;
    }
}