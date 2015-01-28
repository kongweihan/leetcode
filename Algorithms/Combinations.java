public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > 0) dfs(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int n, int k, int num, List<Integer> list, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(list));
        } else {
            for (int i = num; i <= n; i++) {
                list.add(i);
                dfs(n, k - 1, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
