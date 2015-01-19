public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        String[] ss = s.split(" ");
        return ss[ss.length - 1].length();
    }
}
