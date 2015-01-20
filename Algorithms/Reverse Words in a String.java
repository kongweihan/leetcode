public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i > 0; i--) {
            if (ss[i].equals("")) continue;
            sb.append(ss[i]);
            sb.append(" ");
        }
        sb.append(ss[0]);
        return sb.toString();
    }
}
