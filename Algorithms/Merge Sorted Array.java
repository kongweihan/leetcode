public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int[] C = new int[m+n];
        for (int i = 0, j = 0; i < m || j < n;) {
            if (i == m) {
                C[i+j] = B[j];
                j++;
            } else if (j == n) {
                C[i+j] = A[i];
                i++;
            } else {
                if (A[i] < B[j]) {
                    C[i+j] = A[i];
                    i++;
                } else {
                    C[i+j] = B[j];
                    j++;
                }
            }
        }
        for (int i = 0; i < m+n; i++) {
            A[i] = C[i];
        }
    }
}
