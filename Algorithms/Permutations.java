public class Solution {
    public List<List<Integer>> permute(int[] num) {
        boolean[] used = new boolean[num.length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length == 0) return result;
        List<Integer> list = new ArrayList<Integer>();
        dfs(num, num.length, list, used, result);
        return result;
    }
    
    private void dfs(int[] num, int n, List<Integer> list, boolean[] used, List<List<Integer>> result) {
        if (list.size() == n) {
            result.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < n; i++) {
                if (used[i] == false) {
                    used[i] = true;
                    list.add(num[i]);
                    dfs(num, n, list, used, result);
                    list.remove(list.size()-1);
                    used[i] = false;
                }
            }
        }
    }
}
