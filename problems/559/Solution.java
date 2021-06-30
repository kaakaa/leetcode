// Runtime: 1 ms, faster than 41.86% of Java online submissions for Maximum Depth of N-ary Tree.
// Memory Usage: 38.7 MB, less than 95.68% of Java online submissions for Maximum Depth of N-ary Tree.
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
    public int maxDepth(Node root) {
        int depth = 0;
        if (root == null) return depth;
        List<Node> nodes = Arrays.asList(root);
        while (!nodes.isEmpty()) {
            List<Node> next = new ArrayList<>();
            for (Node n : nodes) {
                if (n.children != null) next.addAll(n.children);
            }
            nodes = next;
            depth++;
        }
        return depth;
    }
}