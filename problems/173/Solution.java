// Runtime: 15 ms, faster than 71.48% of Java online submissions for Binary Search Tree Iterator.
// Memory Usage: 42.6 MB, less than 48.52% of Java online submissions for Binary Search Tree Iterator.
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class BSTIterator {
    private List<Integer> list;
    private int n = 0;

    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        find(root);
        this.n = 0;
    }

    private void find(TreeNode par) {
        if (par.left != null) {
            find(par.left);
        }
        this.list.add(par.val);
        if (par.right != null) {
            find(par.right);
        }
    }

    public int next() {
        int ret = list.get(n++);
        return ret;
    }

    public boolean hasNext() {
        return n < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */