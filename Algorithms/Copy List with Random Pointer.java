/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        // insert duplicated node
        RandomListNode curr = head, next = head.next;
        while (next != null) {
            curr.next = new RandomListNode(curr.label);
            curr.next.next = next;
            curr = next;
            next = next.next;
        }
        curr.next = new RandomListNode(curr.label);
        // copy random pointer
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        // split list
        RandomListNode dummy = new RandomListNode(0);
        curr = head;
        RandomListNode node = dummy;
        while (curr != null) {
            node.next = curr.next;
            node = node.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
