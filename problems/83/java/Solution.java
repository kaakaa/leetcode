// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
// Memory Usage: 38.6 MB, less than 40.26% of Java online submissions for Remove Duplicates from Sorted List.
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

        ListNode ret = head;
        ListNode next = head.next;
        while (next != null) {
            if (head.val != next.val) {
                head.next = next;
                head = next;
            }
            next = next.next;
        }
        head.next = null;
        return ret;
    }
}