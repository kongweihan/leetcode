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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode node = head;
            head = head.next;
            // insert
            insert(dummy, node);
        }
        return dummy.next;
    }
    
    public void insert(ListNode dummy, ListNode node) {
        while (dummy.next != null && dummy.next.val < node.val) {
            dummy = dummy.next;
        }
        if (dummy.next != null) {
            node.next = dummy.next;
            dummy.next = node;
        } else {
            node.next = null;
            dummy.next = node;
        }
    }
}
