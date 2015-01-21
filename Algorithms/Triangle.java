public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        for (int i = triangle.size()-2; i >= 0; i--) {
            List<Integer> level = triangle.get(i);
            for (int j = 0; j < level.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + level.get(j);
            }
        }
        return dp[0];
    }
}
