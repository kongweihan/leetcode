public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        int w = L[0].length(), n = L.length;
        int l = w * n;
        List<Integer> result = new ArrayList<Integer>();
        // initialize hash
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (String word : L) {
            if (hash.containsKey(word)) hash.put(word, hash.get(word) + 1);
            else hash.put(word, 1);
        }
        
        for (int i = 0; i < S.length() - l + 1; i++) {
            // DFS
            if (dfs(S, i, 0, n, w, hash)) result.add(i);
        }
        return result;
    }
    
    public boolean dfs(String S, int i, int wc, int n, int w, HashMap<String, Integer> hash) {
        if (wc == n) return true;
        String word = S.substring(i + wc * w, i + (wc + 1) * w);
        if (hash.containsKey(word) && hash.get(word) > 0) {
            hash.put(word, hash.get(word) - 1);
            if (dfs(S, i, wc + 1, n, w, hash)) {
                hash.put(word, hash.get(word) + 1);
                return true;
            }
            else hash.put(word, hash.get(word) + 1);
        }
        return false;
    }
}
