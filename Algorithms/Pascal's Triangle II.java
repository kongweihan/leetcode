public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int k = 1; k <= rowIndex; k++) {
            int prev = 1;
            for (int i = 1; i < k; i++) {
                int curr = list.get(i);
                list.set(i, prev + curr);
                prev = curr;
            }
            list.add(prev);
        }
        return list;
    }
}
