// Runtime: 439 ms, faster than 7.00% of Java online submissions for Intersection of Two Linked Lists.
// Memory Usage: 41.9 MB, less than 47.08% of Java online submissions for Intersection of Two Linked Lists.
// refs: https://qiita.com/mhiro216/items/711c693bc7da7fcbe0b6
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headA : a.next;
            b = b == null ? headB : b.next;
        }
        return a;
    }
}