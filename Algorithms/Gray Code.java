public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                int num = list.get(size - j - 1);
                num = num | (1 << i);
                list.add(num);
            }
        }
        return list;
    }
}
