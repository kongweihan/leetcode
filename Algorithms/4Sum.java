public class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        result = new ArrayList<List<Integer>>();
        for (int i = 0; i <= num.length - 4; i++) {
            for (int j = i + 1; j <= num.length - 3; j++) {
                twoSum(num, j + 1, target - num[i] - num[j], i, j);
                while (j < num.length - 3 && num[j] == num[j + 1]) j++;
            }
            while (i < num.length - 4 && num[i] == num[i + 1]) i++;
        }
        return result;
    }
    
    public void twoSum(int[] num, int start, int target, int first, int second) {
        int end = num.length - 1;
        while (start < end) {
            if (num[start] + num[end] == target) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(num[first]);
                list.add(num[second]);
                list.add(num[start]);
                list.add(num[end]);
                result.add(list);
                while (start < end && num[start] == num[start + 1]) start++;
                while (start < end && num[end] == num[end - 1]) end--;
                start++;
                end--;
            } else if (num[start] + num[end] > target) end--;
            else start++;
        }
    }
}
