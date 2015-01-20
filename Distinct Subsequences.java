public class Solution {
    private int count = 0;
    public int numDistinct(String S, String T) {
        int N = S.length();
        int M = T.length();
        if (N < M) return 0;
        int[][] dp = new int[N][M];
        // dp[i][j] = # subsequence of T[j..M-1] in S[i..N-1]
        // right-bottom
        dp[N-1][M-1] = S.charAt(N-1) == T.charAt(M-1) ? 1 : 0;
        // last row
        for (int col = 0; col < M-1; col++) dp[N-1][col] = 0;
        // last col
        for (int row = N-2; row >= 0; row--) {
            dp[row][M-1] = S.charAt(row) == T.charAt(M-1) ? dp[row+1][M-1] + 1 : dp[row+1][M-1];
        }
        // dp
        for (int row = N-2; row >= 0; row--) {
            for (int col = M-2; col >= 0; col--) {
                if (S.charAt(row) == T.charAt(col)) dp[row][col] = dp[row+1][col+1];
                dp[row][col] += dp[row+1][col];
            }
        }
        return dp[0][0];
    }
}
