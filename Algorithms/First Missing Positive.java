public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1 && A[i] > 0 && A[i] <= A.length) {
                int num = A[i];
                if (A[num-1] != num) {
                    A[i] = A[num-1];
                    A[num-1] = num;
                    i--;
                }
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1) return i+1;
        }
        return A.length + 1;
    }
}
