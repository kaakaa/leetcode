// Runtime: 1 ms, faster than 74.09% of Java online submissions for Remove Linked List Elements.
// Memory Usage: 46 MB, less than 5.06% of Java online submissions for Remove Linked List Elements.
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (head != null) {
            if (head.val != val) {
                prev.next = head;
                prev = head;
            }
            head = head.next;
            prev.next = null;
        }
        return dummy.next;
    }
}