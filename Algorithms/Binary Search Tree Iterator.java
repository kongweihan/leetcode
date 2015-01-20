/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    public TreeNode next, root;
    public BSTIterator(TreeNode root) {
        this.root = root;
        if (root == null) next = null;
        else next = min(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return next != null;
    }

    /** @return the next smallest number */
    public int next() {
        int result = next.val;
        if (next.right != null) {
            next = min(next.right);
        } else {
            // binary search
            TreeNode node = root, prev = null;
            while (node != next) {
                if (node.val >= next.val) {
                    prev = node;
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            next = prev;
        }
        return result;
    }
    
    private TreeNode min(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
