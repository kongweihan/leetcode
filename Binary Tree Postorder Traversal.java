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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode dummy = new TreeNode(-1);
        TreeNode node = root, prev = dummy;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                // right children is done
                if (node.right == null || prev == null || node.right == prev) {
                    result.add(node.val);
                    prev = node;
                    node = null;
                }
                // right children is not done
                else {
                    stack.push(node); // push it back for visiting after right subtree is done
                    node = node.right;
                }
            }
        }
        return result;
    }
}
