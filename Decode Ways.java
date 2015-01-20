public class Solution {
    private int count = 0;
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        // dp[i] = # decoding in s[i..end]
        dp[s.length()] = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            if (i < s.length() - 1 && s.charAt(i) == '0' && s.charAt(i+1) == '0') return 0;
            if ('1' <= s.charAt(i) && s.charAt(i) <= '9') {
                dp[i] = dp[i+1];
            }
            if (s.charAt(i) == '0') {
                if (i == 0 || s.charAt(i-1) > '2') return 0;
            }
            else if (i < s.length() - 1 && Integer.parseInt(s.substring(i, i+2)) <= 26) {
                dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
}
