public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        // initialize hash
        for (char ch : T.toCharArray()) {
            if (hash.containsKey(ch)) hash.put(ch, hash.get(ch) + 1);
            else hash.put(ch, 1);
        }
        int minLength = Integer.MAX_VALUE;
        String minString = "";
        int numZero = 0;
        int start = -1;
        for (int end = 0; end < S.length(); end++) {
            char ch = S.charAt(end);
            if (numZero < hash.keySet().size()) {
                if (hash.containsKey(ch)) {
                    if (start == -1) start = end;
                    hash.put(ch, hash.get(ch) - 1);
                    if (hash.get(ch) == 0) numZero++;
                    if (numZero == hash.keySet().size()) {
                        // move forward `start`
                        while (!hash.containsKey(S.charAt(start)) || hash.get(S.charAt(start)) < 0) {
                            if (hash.containsKey(S.charAt(start))) hash.put(S.charAt(start), hash.get(S.charAt(start)) + 1);
                            start++;
                        }
                        if (end - start + 1 < minLength) {
                            minLength = end - start + 1;
                            minString = S.substring(start, end + 1);
                        }
                    }
                }
            } else {
                if (ch == S.charAt(start)) {
                    // move forward `start`
                    start++;
                    while (!hash.containsKey(S.charAt(start)) || hash.get(S.charAt(start)) < 0) {
                        if (hash.containsKey(S.charAt(start))) hash.put(S.charAt(start), hash.get(S.charAt(start)) + 1);
                        start++;
                    }
                    if (end - start + 1 < minLength) {
                        minLength = end - start + 1;
                        minString = S.substring(start, end + 1);
                    }
                } else if (hash.containsKey(ch)) {
                    hash.put(ch, hash.get(ch) - 1);
                }
            }
        }
        return minString;
    }
}
