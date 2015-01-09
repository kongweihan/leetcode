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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode buildTree(int[] in, int ins, int ine, int[] po, int pos, int poe) {
        if (ine < ins) return null;
        int mid = getIndex(in, po[poe], ins, ine);
        TreeNode root = new TreeNode(po[poe]);
        if (mid - ins > 0) root.left = buildTree(in, ins, mid - 1, po, pos, pos + mid - ins - 1);
        if (ine - mid > 0) root.right = buildTree(in, mid + 1, ine, po, pos + mid - ins, poe - 1);
        return root;
    }
    
    public int getIndex(int[] arr, int elem, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == elem) return i;
        }
        return -1;
    }
}
