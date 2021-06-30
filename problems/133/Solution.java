// Runtime: 24 ms, faster than 98.75% of Java online submissions for Clone Graph.
// Memory Usage: 38.9 MB, less than 89.66% of Java online submissions for Clone Graph.
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return recursion(node, new HashMap<>());
    }
    
    private Node recursion(Node node, Map<Integer, Node> track) { 
        Node newNode = new Node(node.val);
        track.put(node.val, newNode);
        for (Node n : node.neighbors) {
            if (track.containsKey(n.val)) {
                newNode.neighbors.add(track.get(n.val));
            } else {
                newNode.neighbors.add(recursion(n, track));
            }
        }
        return newNode;
    }
}
