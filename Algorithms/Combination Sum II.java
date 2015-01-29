public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(num, target, 0, list, result);
        return result;
    }
    
    private void dfs(int[] num, int sum, int i, List<Integer> list, List<List<Integer>> result) {
        if (sum < 0) return;
        if (sum == 0) {
            result.add(new ArrayList<Integer>(list));
        } else {
            for (int j = i; j < num.length; j++) {
                list.add(num[j]);
                dfs(num, sum - num[j], j + 1, list, result);
                list.remove(list.size() - 1);
                while (j < num.length - 1 && num[j] == num[j+1]) j++;
            }
        }
    }
}
