public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < num.length-2; i++) {
            while (i != 0 && i < num.length-2 && num[i] == num[i-1]) {
                i++;
            }
            if (i == num.length-2) break;
            for (int j = i+1, k = num.length-1; j < k;) {
                while (j != i+1 && j < k && num[j] == num[j-1]) {
                    j++;
                }
                while (k != num.length-1 && j < k && num[k] == num[k+1]) {
                    k--;
                }
                if (j == k) break;
                if (num[i] + num[j] + num[k] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    result.add(list);
                }
                if (num[j] + num[k] > -num[i]) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
