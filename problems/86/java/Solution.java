// Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
// Memory Usage: 38.1 MB, less than 80.14% of Java online submissions for Partition List.
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null || x < -100 || x > 100) {
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode node = head;
        while (node != null && node.val < x) {
            prev = node;
            node = node.next;
        }

        ListNode target = node;
        while (target != null) {
            // System.out.println(prev.val + ":" + node.val + ":" + target.val);
            if (target.next != null && target.next.val < x) {
                ListNode swap = target.next;
                target.next = swap.next;
                prev.next = swap;
                swap.next = node;
                prev = swap;
                continue;
            }
            target = target.next;
        }
        return dummy.next;
    }
}