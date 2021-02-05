// Runtime: 1 ms, faster than 17.99% of Java online submissions for Remove Nth Node From End of List.
// Memory Usage: 36.9 MB, less than 66.67% of Java online submissions for Remove Nth Node From End of List.
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            if (n == 1) {
                head.next = null;
                return head;
            }
            if (n == 2) {
                return head.next;
            }
        }

        ListNode ret = null;
        ListNode index = null;
        LinkedList<ListNode> queue = new LinkedList<>();
        queue.offer(head);

        ListNode next = head.next;
        do {
            queue.offer(next);
            if (queue.size() == n + 1) {
                ListNode node = queue.poll();

                if (index == null) {
                    index = node;
                    ret = index;
                } else {
                    index.next = node;
                    index = index.next;
                }
            }
        } while ((next = next.next) != null);

        queue.poll();
        if (queue.size() == 0) {
            index.next = null;
            return ret;
        }
        if (index == null) {
            index = queue.poll();
            ret = index;
        }
        while ((next = queue.poll()) != null) {
            index.next = next;
            index = index.next;
        }

        return ret;
    }
}