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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        // DFS
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> path = new Stack<TreeNode>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                if (node.left == null && node.right == null) {
                    if (node.val == sum) {
                        list.add(node.val);
                        List<Integer> newList = new ArrayList<Integer>(list);
                        result.add(newList);
                        list.removeLast();
                    }
                    node = null;
                } else {
                    stack.push(node);
                    path.push(node);
                    list.add(node.val);
                    sum -= node.val;
                    node = node.left;
                }
            } else {
                node = stack.pop(); // left subtree is done
                // backtrack
                while (path.peek() != node) {
                    sum += path.pop().val;
                    list.removeLast();
                }
                node = node.right;
            }
        }
        return result;
    }
}
