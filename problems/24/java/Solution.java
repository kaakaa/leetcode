// Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
// Memory Usage: 36.6 MB, less than 65.03% of Java online submissions for Swap Nodes in Pairs.
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);

        ListNode base = dummy;
        ListNode prev = head;

        while (prev != null) {
            ListNode next = prev.next;
            if (next == null) {
                break;
            }
            base.next = next;
            prev.next = next.next;
            base.next.next = prev;

            base = prev;
            prev = prev.next;
        }

        return dummy.next;
    }
}
