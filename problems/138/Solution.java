// Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
// Memory Usage: 42.2 MB, less than 5.02% of Java online submissions for Copy List with Random Pointer.
// refs: https://asanchina.wordpress.com/2015/10/03/copy-list-with-random-pointer/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        Node node = head;
        while (node != null) {
            Node swap = node.next;
            node.next = new Node(node.val);
            node.next.next = swap;
            node = swap;
        }
        
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        Node newHead = head.next;
        node = newHead;
        while (head != null) {
            head.next = head.next.next;
            head = head.next;
            if (node.next != null) {
                node.next = node.next.next;
                node = node.next;
            }
        }
        return newHead;
    }
}