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
    public void reorderList(ListNode head) {
        int length = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        if (length <= 2) return;
        
        ListNode mid = dummy;
        for (int i = 0; i < (length + 1)/2; i++) mid = mid.next;
        // reverse list
        ListNode prev = null;
        ListNode curr = mid;
        ListNode next = mid.next;
        for (int i = 0; i < length/2; i++) {
            prev = curr;
            curr = next;
            next = next.next;
            curr.next = prev;
        }
        // weave
        ListNode first = dummy.next;
        ListNode second = curr;
        for (int i = 0; i < (length+1)/2 - 1; i++) {
            next = first.next;
            first.next = second;
            second = second.next;
            first.next.next = next;
            first = next;
        }
        if (length % 2 == 1) {
            first.next = null;
        } else {
            second.next = null;
        }
    }
}
