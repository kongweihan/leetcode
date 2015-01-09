/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            list.add(null);
            return list;
        }
        List[][] trees = new ArrayList[n][n];
        // diagonal
        for (int k = 0; k < n; k++) {
            trees[k][k] = new ArrayList<TreeNode>();
            trees[k][k].add(new TreeNode(k+1));
        }
        // for each off-diagonal
        for (int k = 1; k < n; k++) {
            // make tree of i ~ i+k
            for (int i = 1; i <= n - k; i++) {
                List<TreeNode> list = new ArrayList<TreeNode>();
                // use j as root, notice all matrix idx should be less by 1
                // no left child, j = i
                list.addAll(makeTrees(i, null, trees[i][i+k-1]));
                // have both children
                for (int j = i + 1; j < i + k; j++) {
                    list.addAll(makeTrees(j, trees[i-1][j-2], trees[j][i+k-1]));
                }
                // no right child, j = i+k
                list.addAll(makeTrees(i+k, trees[i-1][i+k-2], null));
                trees[i-1][i+k-1] = list;
            }
        }
        return trees[0][n-1];
    }
    
    public List<TreeNode> makeTrees(int val, List<TreeNode> left, List<TreeNode> right) {
        if (left == null) {
            left = new ArrayList<TreeNode>();
            left.add(null);
        }
        if (right == null) {
            right = new ArrayList<TreeNode>();
            right.add(null);
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        for (TreeNode leftSubTree : left) {
            for (TreeNode rightSubTree: right) {
                TreeNode root = new TreeNode(val);
                root.left = leftSubTree;
                root.right = rightSubTree;
                list.add(root);
            }
        }
        return list;
    }
}
