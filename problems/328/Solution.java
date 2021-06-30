// Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
// Memory Usage: 38.5 MB, less than 70.92% of Java online submissions for Odd Even Linked List.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = head;
        ListNode first = head.next;
        while (prev != null) {
            ListNode odd = prev.next;
            if (odd == null) {
                break;
            }
            ListNode next = odd.next;
            if (next == null) {
                break;
            }
            head.next = next;
            odd.next = next.next;
            
            head = head.next;
            prev = odd;
        }
        head.next = first;
        return dummy.next;
    }
}