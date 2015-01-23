public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int j = 0;
        int val = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] != val) {
                j++;
                A[j] = A[i];
                val = A[i];
            }
        }
        return j+1;
    }
}
