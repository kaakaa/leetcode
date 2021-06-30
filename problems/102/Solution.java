// Runtime: 210 ms, faster than 5.17% of Java online submissions for Binary Tree Level Order Traversal.
// Memory Usage: 116.9 MB, less than 5.14% of Java online submissions for Binary Tree Level Order Traversal.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> leftSubtrees = levelOrder(root.left);
        List<List<Integer>> rightSubtrees = levelOrder(root.right);
        
        // adjust two list as same size
        int lSize = leftSubtrees.size();
        if (lSize < rightSubtrees.size()) {
            int sub = rightSubtrees.size() - lSize;
            List<List<Integer>> emptyList = Collections.nCopies(sub, Collections.emptyList());
            leftSubtrees.addAll(emptyList);
        } else {
            int sub = lSize - rightSubtrees.size();
            List<List<Integer>> emptyList = Collections.nCopies(sub, Collections.emptyList());
            rightSubtrees.addAll(emptyList);
        }
        
        List<List<Integer>> subtrees = new ArrayList<>();
        for (int i = 0; i < leftSubtrees.size(); i++) {
            List<Integer> temp = Arrays.asList(leftSubtrees.get(i), rightSubtrees.get(i)).stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());
            subtrees.add(temp);            
        }
        
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>(Arrays.asList(root.val)));
        ret.addAll(subtrees);
        return ret;
    }
}