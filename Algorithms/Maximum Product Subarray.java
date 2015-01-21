public class Solution {
    public int maxProduct(int[] A) {
        int max = A[0];
        int pos = 1, neg = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                pos = 1;
                neg = 1;
                max = Math.max(max, 0);
                continue;
            }
            pos *= A[i];
            neg *= A[i];
            if (pos < neg) {
                int tmp = pos;
                pos = neg;
                neg = tmp;
            }
            max = Math.max(max, pos);
            if (pos < 0) {
                pos = 1;
            }
        }
        return max;
    }
}
