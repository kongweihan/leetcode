public class Solution {
    public boolean isMatch(String s, String p) {
        return recurMatch(s, p, 0, 0);
    }
    
    private boolean recurMatch(String s, String p, int si, int pi) {
        // pi never points to a '*'
        
        // pi points to end of p
        if (pi == p.length()) return si == s.length();
        // pi points to last char of p, so there's no '*' after pi
        // so, p[pi] must match s[si], si must be last char of s
        if (pi == p.length() - 1) return si == s.length() - 1 && match(s.charAt(si), p.charAt(pi));
        // pi doesn't points to last char, p[pi+1] exists
        // if p[pi+1] is '*'
        if (p.charAt(pi+1) == '*') {
            // p[pi] match "" in s
            if (recurMatch(s, p, si, pi+2)) return true;
            // p[pi] match 1+ number of char in s start at si
            while (si < s.length() && match(s.charAt(si), p.charAt(pi))) {
                if (recurMatch(s, p, si+1, pi+2)) return true;
                si++;
            }
            return false;
        } else {
            // p[pi] must match s[si]
            return si < s.length() && match(s.charAt(si), p.charAt(pi)) && recurMatch(s, p, si+1, pi+1);
        }
    }
    
    private boolean match(char s, char p) {
        return s == p || p == '.';
    }
}
