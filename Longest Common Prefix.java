public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int i = 0;
        while (true) {
            if (i == strs[0].length()) break;
            char ch = strs[0].charAt(i);
            boolean stop = false;
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    stop = true;
                    break;
                }
            }
            if (stop) break;
            i++;
        }
        return strs[0].substring(0, i);
    }
}
