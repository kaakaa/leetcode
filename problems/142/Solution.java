// Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
// Memory Usage: 39.1 MB, less than 43.35% of Java online submissions for Linked List Cycle II.
// refs: https://qiita.com/mhiro216/items/b5e9f4cfd47eb1dcc1cb
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next == head) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
        } while(slow != fast);
        
        while (slow != head) {
            slow = slow.next;
            head = head.next;
        }
        return slow;
    }
}