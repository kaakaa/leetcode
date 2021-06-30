// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
// Memory Usage: 38.4 MB, less than 56.57% of Java online submissions for Remove Duplicates from Sorted List II.
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode base = dummy;
        ListNode next = head;
        while (next != null) {
            if (next.next == null || next.val != next.next.val) {
                base.next = next;
                base = next;
                next = next.next;
                continue;
            }

            // cond: next.val == next.next.val
            int n = next.val;
            while (next != null && next.val == n) {
                next = next.next;
            }
            if (next == null) {
                break;
            }
        }
        base.next = null;
        return dummy.next;
    }
}