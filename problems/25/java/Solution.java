// Runtime: 1 ms, faster than 26.15% of Java online submissions for Reverse Nodes in k-Group.
// Memory Usage: 39.3 MB, less than 56.01% of Java online submissions for Reverse Nodes in k-Group.
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode node = head;
        while (node != null && queue.size() < k) {
            queue.offerLast(node);
            node = node.next;
        }

        if (queue.size() == 0) {
            return null;
        }

        if (queue.size() < k) {
            ListNode newHead = queue.pollFirst();
            node = newHead;
            while (queue.peekFirst() != null) {
                node.next = queue.pollFirst();
                node = node.next;
            }
            return newHead;
        }

        ListNode newHead = queue.pollLast();
        ListNode swap = newHead.next;
        node = newHead;
        while (queue.peekLast() != null) {
            node.next = queue.pollLast();
            node = node.next;
        }

        if (swap != null) {
            node.next = reverseKGroup(swap, k);
        } else {
            node.next = swap;
        }
        return newHead;
    }
}
