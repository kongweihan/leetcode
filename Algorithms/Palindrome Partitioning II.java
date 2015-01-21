public class Solution {
    public int minCut(String s) {
        int N = s.length();
        int[] dp = new int[N]; // dp[i] = min cuts of s[0..i]
        for (int i = 0; i < N; i++) dp[i] = i;
        for (int i = 1; i < N; i++) { // min[0]...min[i-1] are determined
            // odd pal
            for (int l = i, r = i; l >= 0 && r < N && s.charAt(l) == s.charAt(r); l--, r++) {
                if (l == 0) dp[r] = 0;
                else dp[r] = Math.min(dp[r], dp[l-1] + 1);
            }
            // even pal
            for (int l = i-1, r = i; l >= 0 && r < N && s.charAt(l) == s.charAt(r); l--, r++) {
                if (l == 0) dp[r] = 0;
                else dp[r] = Math.min(dp[r], dp[l-1] + 1);
            }
        }
        return dp[N-1];
    }
}
