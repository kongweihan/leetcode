public class Solution {
    private int longest = 0;
    private String pal = "";
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            getEvenPal(s, i);
            getOddPal(s, i);
        }
        return pal;
    }
    
    private void getEvenPal(String s, int i) {
        int length = 0;
        int j = i, k = i + 1;
        for (; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k); j--, k++) {
            length += 2;
        }
        if (length > longest) {
            pal = s.substring(j+1, k);
            longest = length;
        }
    }
    
    private void getOddPal(String s, int i) {
        int length = 1;
        int j = i - 1, k = i + 1;
        for (; j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k); j--, k++) {
            length += 2;
        }
        if (length > longest) {
            pal = s.substring(j+1, k);
            longest = length;
        }
    }
}
