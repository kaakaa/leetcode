// Runtime: 2385 ms, faster than 5.06% of Java online submissions for Rotate List.
// Memory Usage: 38.2 MB, less than 87.66% of Java online submissions for Rotate List.
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        Queue<ListNode> queue = new LinkedList<>();
        while (head != null) {
            if (queue.size() == k + 1) {
                queue.poll();
            }
            queue.offer(head);
            head = head.next;
        }

        while (queue.size() <= k) {
            k -= queue.size();
        }
        while (queue.size() > k + 1) {
            queue.poll();
        }

        if (k == 0 || queue.size() == 0) {
            return dummy.next;
        }

        queue.poll().next = null;
        ListNode base = dummy;
        ListNode next = dummy.next;
        while (queue.size() > 0) {
            ListNode node = queue.poll();
            base.next = node;
            node.next = next;

            base = node;
        }

        return dummy.next;
    }
}