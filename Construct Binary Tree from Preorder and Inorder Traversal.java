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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] pr, int prs, int pre, int[] in, int ins, int ine) {
        if (ine < ins) return null;
        int mid = getIndex(in, pr[prs], ins, ine);
        TreeNode root = new TreeNode(pr[prs]);
        if (mid - ins > 0) root.left = buildTree(pr, prs + 1, prs + mid - ins, in, ins, mid - 1);
        if (ine - mid > 0) root.right = buildTree(pr, prs + mid - ins + 1, pre, in, mid + 1, ine);
        return root;
    }
    
    public int getIndex(int[] arr, int elem, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == elem) return i;
        }
        return -1;
    }
}
