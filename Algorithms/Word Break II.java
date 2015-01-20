public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        HashSet<Integer> fail = new HashSet<Integer>();
        dfs(s, 0, null, dict, result, fail);
        return result;
    }
    
    private boolean dfs(String s, int idx, String sent, Set<String> dict, List<String> result, HashSet<Integer> fail) {
        if (idx == s.length()) {
            result.add(sent);
            return true;
        } else {
            if (fail.contains(idx)) return false;
            boolean any = false;
            for (int i = idx + 1; i <= s.length(); i++) {
                if (dict.contains(s.substring(idx, i))) {
                    String newSent;
                    if (sent == null) newSent = s.substring(idx, i);
                    else newSent = sent + " " + s.substring(idx, i);
                    if (dfs(s, i, newSent, dict, result, fail)) any = true;
                }
            }
            if (!any) fail.add(idx);
            return any;
        }
    }
}
