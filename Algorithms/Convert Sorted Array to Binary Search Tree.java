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
    public TreeNode sortedArrayToBST(int[] num) {
        return toBST(num, 0, num.length);
    }
    
    private TreeNode toBST(int[] num, int head, int tail) {
        if (head == tail) return null;
        int mid = (tail + head - 1) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = toBST(num, head, mid);
        root.right = toBST(num, mid + 1, tail);
        return root;
    }
}
