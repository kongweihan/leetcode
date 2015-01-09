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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode node = root;
    
    	while (node != null || !stack.isEmpty()) {
    	    if (node != null) {
    	        stack.push(node);
    	        node = node.left;
    	    } else {
    	        node = stack.pop(); // node.left subtree is done by now
    	        result.add(node.val);
    	        node = node.right;
    	    }
    	}
    	return result;
    }
}
