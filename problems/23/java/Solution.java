// Runtime: 257 ms, faster than 7.76% of Java online submissions for Merge k Sorted Lists.
// Memory Usage: 40.9 MB, less than 41.88% of Java online submissions for Merge k Sorted Lists.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1001);
        ListNode head = dummy;
        while(true) {
            int idx = -1;
            ListNode minNode = null;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (minNode == null || lists[i].val < minNode.val) {
                        minNode = lists[i];
                        idx = i;
                    }
                }
            }
            if (minNode == null) {
                break;
            }
            head.next = new ListNode(minNode.val);
            head = head.next;
            lists[idx] = minNode.next;
        }
        return dummy.next;
    }
}