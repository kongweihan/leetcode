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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sumRootLeaf(root, 0);
        return sum;
    }
    int sum = 0;
    public void sumRootLeaf(TreeNode root, int val) {
        if (root.left == null && root.right == null) sum += val*10 + root.val;
        if (root.left != null) sumRootLeaf(root.left, val*10 + root.val);
        if (root.right != null) sumRootLeaf(root.right, val*10 + root.val);
    }
}
