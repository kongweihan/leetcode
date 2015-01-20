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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        LinkedList<TreeNode> curQueue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextQueue = new LinkedList<TreeNode>();
        int level = 1;
        List<Integer> nextLevelList = new ArrayList<Integer>();
        nextLevelList.add(root.val);
        result.add(nextLevelList);
        nextLevelList = new ArrayList<Integer>();
        while (!curQueue.isEmpty()) {
            
        }
        return result;
    }
}
