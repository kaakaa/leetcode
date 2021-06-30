// Runtime: 6 ms, faster than 9.16% of Java online submissions for N-ary Tree Postorder Traversal.
// Memory Usage: 47.2 MB, less than 5.44% of Java online submissions for N-ary Tree Postorder Traversal.
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        for (Node node : root.children) {
            ret.addAll(postorder(node));
        }
        ret.add(root.val);
        return ret;
    }
}