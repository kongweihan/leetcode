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
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.addLast(root);
        int level = 1, nextLevel = 0;
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.removeFirst();
            if (node.left != null) {
                queue.addLast(node.left);
                queue.addLast(node.right);
                nextLevel += 2;
                node.left.next = node.right;
                if (node.next != null) {
                    node.right.next = node.next.left;
                }
            }
            level--;
            if (level == 0) {
                level = nextLevel;
                nextLevel = 0;
            }
        }
    }
}
