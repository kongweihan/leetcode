public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        // first row, "" to word2[1..col]
        for (int col = 1; col <= word2.length(); col++) {
            dp[0][col] = col;
        }
        // first col, word1[1..row] to ""
        for (int row = 1; row <= word1.length(); row++) {
            dp[row][0] = row;
        }
        // dp
        for (int row = 1; row <= word1.length(); row++) {
            for (int col = 1; col <= word2.length(); col++) {
                if (word1.charAt(row-1) == word2.charAt(col-1)) {
                    dp[row][col] = dp[row-1][col-1];
                } else {
                    dp[row][col] = Math.min(Math.min(dp[row][col-1], dp[row-1][col]), dp[row-1][col-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
