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
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int length = getLength(head);
        int level = 0;
        while (Math.pow(2,level) < length) level++;
        for (int i = 1; i <= level; i++) {
            int n = (int)Math.pow(2,i);
            mergeLevel(dummy, n);
        }
        return dummy.next;
    }
    
    public void mergeLevel(ListNode dummy, int n) {
        while (dummy.next != null) {
            ListNode slow = dummy, fast = dummy;
            for (int i = 0; i < n/2; i++) {
                if (slow == null) break;
                slow = slow.next;
                if (fast == null || fast.next == null) {
                    fast = null;
                } else {
                    fast = fast.next.next;
                }
            }
            ListNode postSecondTail = fast == null ? null : fast.next;
            ListNode secondHead = slow == null ? null : slow.next;
            ListNode tail = merge(dummy, secondHead, postSecondTail, n);
            tail.next = postSecondTail;
            dummy = tail;
        }
    }
    
    public ListNode merge(ListNode prevFirstHead, ListNode secondHead, ListNode postSecondTail, int n) {
        ListNode first = prevFirstHead.next;
        ListNode second = secondHead;
        ListNode dummy = prevFirstHead;
        for (int i = 0; i < n; i++) {
            if (first == secondHead && second == postSecondTail) break;
            if (first == secondHead) {
                dummy.next = second;
                second = second.next;
            } else if (second == postSecondTail || first.val <= second.val) {
                dummy.next = first;
                first = first.next;
            } else {
                dummy.next = second;
                second = second.next;
            }
            dummy = dummy.next;
        }
        return dummy;
    }
    
    public int getLength(ListNode head) {
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        return l;
    }
}
