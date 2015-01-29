public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int l = 0; l < n/2; l++) {
            for (int i = 0; i < n - l*2 - 1; i++) {
                int tmp = matrix[l][l+i];
                matrix[l][l+i] = matrix[n-1-l-i][l];
                matrix[n-1-l-i][l] = matrix[n-1-l][n-1-l-i];
                matrix[n-1-l][n-1-l-i] = matrix[l+i][n-1-l];
                matrix[l+i][n-1-l] = tmp;
            }
        }
    }
}
