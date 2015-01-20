public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        return dfs(s, 0, dict, new HashSet<Integer>());
    }
    
    private boolean dfs(String s, int idx, Set<String> dict, Set<Integer> fail) {
        if (s.length() == idx) return true;
        if (fail.contains(idx)) return false;
        for (int i = idx + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(idx, i))) {
                if (dfs(s, i, dict, fail)) return true;
            }
        }
        fail.add(idx);
        return false;
    }
}
