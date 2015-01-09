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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                node.next = new ListNode((l1.val + l2.val + carry) % 10);
                carry = (l1.val + l2.val + carry) / 10;
                node = node.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                node.next = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                node = node.next;
                l2 = l2.next;
            } else {
                node.next = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;
                node = node.next;
                l1 = l1.next;
            }
        }
        if (carry == 1) node.next = new ListNode(1);
        return dummy.next;
    }
}
