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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        List<Integer> list;
        int level = 1;
        while (true) {
            list = new ArrayList<Integer>();
            recursiveLevelOrder(root, level, list);
            if (list.size() == 0) break;
            else result.add(list);
            level++;
        }
        
        return result;
    }
    
    void recursiveLevelOrder(TreeNode root, int level, List<Integer> list) {
        if (level == 1) {
            list.add(root.val);
        } else {
            if (root.left != null) recursiveLevelOrder(root.left, level - 1, list);
            if (root.right != null) recursiveLevelOrder(root.right, level - 1, list);
        }
    }
}
