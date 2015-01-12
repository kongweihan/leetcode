public class Solution {
    public boolean isMatch(String s, String p) {
        // idea: when meet * in pattern, try match s for 0 char, and keep going, if not work, come back and match 1 char
        // there is no need to use stack for each *, because once we meet a new *, we don't need to try to match more char for any previous *
        int sp = 0, pp = 0, sm = -1, pm = -1;
        while (sp < s.length()) {
            if (pp < p.length() && match(s, sp, p, pp)) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                sm = sp;
                pm = pp + 1;
                pp++;
            } else if (pm != -1) {
                sm++;
                sp = sm;
                pp = pm;
            } else {
                return false;
            }
        }
        while (pp < p.length()) {
            if (p.charAt(pp) != '*') return false;
            pp++;
        }
        return true;
    }
    
    private boolean match(String s, int sp, String p, int pp) {
        return s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?';
    }
}
