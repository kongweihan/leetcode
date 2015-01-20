public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = next(s);
        }
        return s;
    }
    
    private String next(String s) {
        StringBuilder sb = new StringBuilder();
        char ch = s.charAt(0);
        int i = 0;
        int count = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ch) {
                count++;
                i++;
            } else {
                sb.append(new Integer(count).toString());
                sb.append(ch);
                ch = s.charAt(i);
                count = 0;
            }
        }
        sb.append(new Integer(count).toString());
        sb.append(ch);
        return sb.toString();
    }
}
