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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (hasK(node, k)) {
            node = reverse(node, k);
        }
        return dummy.next;
    }
    public boolean hasK(ListNode node, int k) {
        for (int i = 0; i < k; i++) {
            node = node.next;
            if (node == null) return false;
        }
        return true;
    }
    public ListNode reverse(ListNode dummy, int k) {
        ListNode curr = dummy.next, next = dummy.next.next, prev = null;
        for (int i = 0; i < k - 1; i++) {
            prev = curr;
            curr = next;
            next = next.next;
            curr.next = prev;
        }
        dummy.next.next = next;
        ListNode tail = dummy.next;
        dummy.next = curr;
        return tail;
    }
}
