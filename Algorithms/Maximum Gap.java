public class Solution {
    public int maximumGap(int[] num) {
        radixSort(num);
        int maxGap = 0;
        for (int i = 1; i < num.length; i++) {
            maxGap = Math.max(num[i] - num[i-1], maxGap);
        }
        return maxGap;
    }
    
    private void radixSort(int[] num) {
        for (int i = 0; i < 31; i++) {
            int count0 = 0;
            int needle = 1 << i;
            for (int idx = 0; idx < num.length; idx++) {
                if ((num[idx] & needle) == 0) count0++;
            }
            int count1 = num.length;
            int[] tmp = new int[num.length];
            for (int idx = num.length - 1; idx >= 0; idx--) {
                if ((num[idx] & needle) == 0) {
                    tmp[count0 - 1] = num[idx];
                    count0--;
                } else {
                    tmp[count1 - 1] = num[idx];
                    count1--;
                }
            }
            for (int idx = 0; idx < num.length; idx ++) num[idx] = tmp[idx];
        }
    }
}
