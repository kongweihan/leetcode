/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        LinkedList<TreeLinkNode> thisQueue = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> nextQueue = new LinkedList<TreeLinkNode>();
        LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
        thisQueue.addLast(root);
        while (!thisQueue.isEmpty()) {
            TreeLinkNode node = thisQueue.removeFirst();
            if (node.left != null) {
                nextQueue.addLast(node.left);
                list.addLast(node.left);
            }
            if (node.right != null) {
                nextQueue.addLast(node.right);
                list.addLast(node.right);
            }
            if (thisQueue.isEmpty()) {
                thisQueue = nextQueue;
                nextQueue = new LinkedList<TreeLinkNode>();
                // populate next pointer
                if (!list.isEmpty()) {
                    TreeLinkNode curr = list.removeFirst();
                    while (!list.isEmpty()) {
                        curr.next = list.getFirst();
                        curr = list.removeFirst();
                    }
                }
            }
        }
    }
}
