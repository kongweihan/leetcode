public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (numRows == 0) return lists;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        lists.add(list);
        for (int i = 2; i <= numRows; i++) {
            list = new ArrayList<Integer>();
            List<Integer> prev = lists.get(i - 2);
            list.add(prev.get(0));
            for (int j = 0; j < prev.size() - 1; j++) {
                list.add(prev.get(j) + prev.get(j + 1));
            }
            list.add(prev.get(prev.size() - 1));
            lists.add(list);
        }
        return lists;
    }
}
