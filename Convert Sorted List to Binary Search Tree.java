/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }
    
    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode mid = split(head, tail);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head, mid);
        root.right = sortedListToBST(mid.next, tail);
        return root;
    }
    
    private ListNode split(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
