// Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten a Multilevel Doubly Linked List.
// Memory Usage: 38.8 MB, less than 5.66% of Java online submissions for Flatten a Multilevel Doubly Linked List.
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        
        while (head != null) {
            if (head.child != null) {
                Node swap = head.next;
                head.next = head.child;
                head.child.prev = head;
                
                Node last = combine(head.child);
                head.child = null;
                if (swap == null) {
                    break;
                }
                
                last.next = swap;
                swap.prev = last;
                head = swap;
                continue;
            }
            head = head.next;
        }
        return dummy.next;
    }
    
    private Node combine(Node node) {
        while (node != null) {
            if (node.child == null) {
                if (node.next == null) {
                    return node;
                }
                node = node.next;
                continue;
            } 
            
            Node swap = node.next;
                
            node.next = node.child;
            node.child.prev = node;
                
            Node last = combine(node.child);
            node.child = null;
            if (swap == null) {
                return last;
            }
            
            last.next = swap;
            swap.prev = last;            
            node = swap;
        }
        throw null;
    }
}