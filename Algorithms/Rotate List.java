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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // get length
        int length = 0;
        ListNode tail = dummy;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        // find head
        ListNode fast = dummy;
        n = n % length;
        for (int i = 1; i <= length - n; i++) fast = fast.next;
        
        tail.next = head;
        dummy.next = fast.next;
        fast.next = null;
        return dummy.next;
    }
}
