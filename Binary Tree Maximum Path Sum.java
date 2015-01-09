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
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxRootLeafPathSum(root);
        return max;
    }
    
    public int maxRootLeafPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return root.val;
        } else if (root.right == null) {
            int localMax = Math.max(root.val, root.val + maxRootLeafPathSum(root.left));
            max = Math.max(max, localMax);
            return localMax;
        } else if (root.left == null) {
            int localMax = Math.max(root.val, root.val + maxRootLeafPathSum(root.right));
            max = Math.max(max, localMax);
            return localMax;
        } else {
            int left = root.val + maxRootLeafPathSum(root.left);
            int right = root.val + maxRootLeafPathSum(root.right);
            int all = left + right - root.val;
            max = Math.max(max, Math.max(root.val, Math.max(all, Math.max(left, right))));
            return Math.max(root.val, Math.max(left, right));
        }
    }
}
