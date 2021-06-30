// Runtime: 5 ms, faster than 9.75% of Java online submissions for N-ary Tree Level Order Traversal.
// Memory Usage: 39.7 MB, less than 78.09% of Java online submissions for N-ary Tree Level Order Traversal.
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        
        ret.add(Arrays.asList(root.val));
        if (root.children == null) return ret;
        List<Node> children = root.children;
        while (!children.isEmpty()) {
            ret.add(children.stream().map(n -> n.val).collect(Collectors.toList()));
            children = children.stream().filter(n -> n.children != null).flatMap(n -> n.children.stream()).collect(Collectors.toList());
        }
        return ret;
    }
}