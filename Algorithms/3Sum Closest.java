public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int minDiff = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < num.length-2; i++) {
            for (int j = i + 1, k = num.length - 1; j < k;) {
                int tmp = num[i] + num[j] + num[k];
                int diff = Math.abs(target - tmp);
                if (diff < minDiff) {
                    minDiff = diff;
                    sum = tmp;
                }
                if (tmp < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }
}
