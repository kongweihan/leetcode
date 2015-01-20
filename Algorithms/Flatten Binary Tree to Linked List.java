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
    public void flatten(TreeNode root) {
        flattenToRight(root);
    }
    
    public TreeNode flattenToRight(TreeNode root) {
        if (root == null) return null;
        if (root.left != null) {
            TreeNode leftTail = flattenToRight(root.left);
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            leftTail.right = right;
            root = leftTail;
        }
        if (root.right != null) return flattenToRight(root.right);
        else return root;
    }
}
