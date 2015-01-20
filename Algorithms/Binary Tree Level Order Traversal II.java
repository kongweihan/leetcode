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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;
        List<Integer> nextLevelList = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        nextLevelList.add(root.val);
        result.add(nextLevelList);
        queue.addLast(root);
        nextLevelList = new ArrayList<Integer>();
        int level = 1, nextLevel = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            level--;
            if (node.left != null) {
                nextLevelList.add(node.left.val);
                nextLevel++;
                queue.addLast(node.left);
            }
            if (node.right != null) {
                nextLevelList.add(node.right.val);
                nextLevel++;
                queue.addLast(node.right);
            }
            if (level == 0) {
                if (nextLevel > 0) result.addFirst(nextLevelList);
                nextLevelList = new ArrayList<Integer>();
                level = nextLevel;
                nextLevel = 0;
            }
        }
        return result;
    }
}
