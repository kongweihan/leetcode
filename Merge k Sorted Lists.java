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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new NodeComparator());
        int finish = 0;
        // initialize
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            } else {
                finish++;
            }
        }
        // merge
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (finish < lists.size()) {
            node.next = queue.poll();
            node = node.next;
            if (node.next != null) {
                queue.add(node.next);
            } else {
                finish++;
            }
        }
        return dummy.next;
    }
    
    class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode a, ListNode b) {
            if (a.val < b.val) return -1;
            else if (a.val == b.val) return 0;
            else return 1;
        }
    }
}
