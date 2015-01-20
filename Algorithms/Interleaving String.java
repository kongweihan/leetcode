public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        // dp[i][j] s1[i..end] & s2[j..end] interleave s3[i+j..end]
        // bottom-down
        dp[s1.length()][s2.length()] = true;
        // last row
        for (int col = s2.length()-1; col >= 0; col--) {
            int row = s1.length();
            if (dp[row][col+1] && s2.charAt(col) == s3.charAt(row + col))
                dp[row][col] = true;
        }
        // last col
        for (int row = s1.length()-1; row >= 0; row--) {
            int col = s2.length();
            if (dp[row+1][col] && s1.charAt(row) == s3.charAt(row + col))
                dp[row][col] = true;
        }
        // dp
        for (int row = s1.length()-1; row >= 0; row--) {
            for (int col = s2.length()-1; col >= 0; col--) {
                dp[row][col] = (dp[row+1][col] && s1.charAt(row) == s3.charAt(row + col)) || (dp[row][col+1] && s2.charAt(col) == s3.charAt(row + col));
            }
        }
        return dp[0][0];
    }
}
