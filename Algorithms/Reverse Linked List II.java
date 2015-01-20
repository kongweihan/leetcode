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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = dummy;
        for (int i = 1; i <= m - 1; i++) {
            left = left.next;
        }
        // reverse list
        ListNode prev = left.next;
        ListNode curr = prev.next;
        ListNode next = curr == null ? null : curr.next;
        for (int i = 1; i <= n - m; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next == null ? null : next.next;
        }
        left.next.next = curr;
        left.next = prev;
        return dummy.next;
    }
}
