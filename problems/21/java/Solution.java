// Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
// Memory Usage: 38.4 MB, less than 65.72% of Java online submissions for Merge Two Sorted Lists.
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode base = l1;
        ListNode target = l2;
        if (l1.val >= l2.val) {
            base = l2;
            target = l1;
        }
        ListNode ret = base;

        ListNode next = target;
        while (next != null) {
            while (base.next != null && base.next.val < next.val) {
                base = base.next;
            }
            if (base.next == null) {
                base.next = next;
                break;
            }
            base.next = new ListNode(next.val, base.next);
            base = base.next;
            next = next.next;
        }
        return ret;
    }
}