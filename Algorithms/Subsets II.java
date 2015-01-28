public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(list, num, 0, result);
        return result;
    }
    
    private void dfs(List<Integer> list, int[] num, int idx, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(list));
        if (idx == num.length) return;
        for (int i = idx; i < num.length; i++) {
            list.add(num[i]);
            dfs(list, num, i + 1, result);
            list.remove(list.size() - 1);
            while (i < num.length - 1 && num[i] == num[i+1]) i++;
        }
    }
}
