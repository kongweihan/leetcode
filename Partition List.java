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
    public ListNode partition(ListNode head, int x) {
        ListNode dummySmall = new ListNode(-1);
        ListNode dummyBig = new ListNode(-1);
        ListNode small = dummySmall, big = dummyBig;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
                head = head.next;
            } else {
                big.next = head;
                big = big.next;
                head = head.next;
            }
        }
        small.next = dummyBig.next;
        big.next = null;
        return dummySmall.next;
    }
}
