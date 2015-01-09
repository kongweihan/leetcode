public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hash = new HashSet<Character>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (!hash.contains(ch)) {
                hash.add(ch);
                max = Math.max(max, end - start + 1);
            } else {
                // move forard `start`
                while (s.charAt(start) != ch) {
                    hash.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        return max;
    }
}
