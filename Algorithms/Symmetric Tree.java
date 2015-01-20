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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // double pre-order traversal, DFS
        Stack<TreeNode> stackLeft = new Stack<TreeNode>();
        Stack<TreeNode> stackRight = new Stack<TreeNode>();
        stackLeft.push(root.left);
        stackRight.push(root.right);
        while (!stackLeft.isEmpty() && !stackRight.isEmpty()) {
            TreeNode left = stackLeft.pop();
            TreeNode right = stackRight.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            stackLeft.push(left.right);
            stackLeft.push(left.left);
            stackRight.push(right.left);
            stackRight.push(right.right);
        }
        if (stackLeft.isEmpty() && stackRight.isEmpty()) return true;
        return false;
    }
}
