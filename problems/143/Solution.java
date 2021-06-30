// Runtime: 2 ms, faster than 38.19% of Java online submissions for Reorder List.
// Memory Usage: 43.2 MB, less than 13.50% of Java online submissions for Reorder List.
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        LinkedList<ListNode> tmp = new LinkedList<>();
        ListNode node = head.next;
        while (node != null) {
            tmp.offerLast(node);
            node = node.next;
        }

        node = head;
        while (!tmp.isEmpty()) {
            node.next = tmp.pollLast();
            node = node.next;
            if (!tmp.isEmpty()) {
                node.next = tmp.pollFirst();
                node = node.next;
            }
        }
        node.next = null;
        return;
    }
}