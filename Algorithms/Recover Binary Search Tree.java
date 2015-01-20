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
    public void recoverTree(TreeNode root) {
        // in-order Morris traversal
        while (root != null) {
            if (root.left != null) {
                TreeNode leftMax = root.left;
                while (leftMax.right != null && leftMax.right != root) {
                    leftMax = leftMax.right;
                }
                if (leftMax.right == null) {
                    leftMax.right = root;
                    root = root.left;
                } else {
                    leftMax.right = null;
                    visit(root);
                    root = root.right;
                }
            } else {
                visit(root);
                root = root.right;
            }
        }
        
        // switch
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private TreeNode prev = null;
    private TreeNode first = null, second = null;
    private void visit(TreeNode node) {
        if (prev == null) prev = node;
        else if (prev.val > node.val && first == null) {
            first = prev;
            second = node;
            prev = node;
        } else if (prev.val > node.val) {
            second = node;
            prev = node;
        } else {
            prev = node;
        }
    }
}
