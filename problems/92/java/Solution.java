// Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
// Memory Usage: 36.4 MB, less than 89.68% of Java online submissions for Reverse Linked List II.
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = dummy;

        int idx = 1;
        boolean reversing = false;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            if (reversing) {
                stack.push(head);
                if (idx == right) {
                    reversing = false;
                    ListNode swap = stack.peek().next;
                    while (!stack.empty()) {
                        prev.next = stack.pop();
                        prev = prev.next;
                    }
                    prev.next = swap;
                }
            } else {
                if (left == 1 && idx == 1) {
                    reversing = true;
                    stack.push(head);
                } else if (idx == left - 1) {
                    reversing = true;
                    prev = head;
                }
            }
            head = head.next;
            idx++;
        }
        return dummy.next;
    }
}