public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return recur(S, S.length);
    }
    
    private List<List<Integer>> recur(int[] S, int n) {
        if (n == 0) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        } else {
            List<List<Integer>> result = recur(S, n-1);
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<Integer>(result.get(i));
                newSubset.add(S[n-1]);
                result.add(newSubset);
            }
            return result;
        }
    }
}
