// Runtime: 9 ms, faster than 62.43% of Java online submissions for Design Linked List.
// Memory Usage: 40 MB, less than 6.26% of Java online submissions for Design Linked List.
class MyLinkedList {
    private Node head;
    private int n;
    
    class Node {
        public int val;
        public Node next;
        
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.n = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (this.n == 0 || index < 0 || this.n <= index) {
            return -1;
        }
        Node node = this.head;
        while (index-- > 0) { node = node.next; }
        return node.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        this.head = new Node(val, this.head);
        this.n++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (this.head == null) {
            this.addAtHead(val);
            return;
        }
        Node node = this.head;
        while (node.next != null) { node = node.next; }
        node.next = new Node(val, null);
        this.n++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || this.n < index) {
            // invalid index
            return;
        }
        if (index == 0) {
            this.addAtHead(val);
            return;
        }
        Node node = this.head;
        while (index-- > 1) { node = node.next; }
        Node newNode = new Node(val, node.next);
        node.next = newNode;
        this.n++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || this.n <= index) {
            // invalid index
            return;
        }
        if (index == 0) {
            this.head = this.head.next;
            this.n--;
            return;
        }
        Node node = this.head;
        while (index-- > 1) { node = node.next; }
        node.next = node.next != null ? node.next.next : null;
        this.n--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */