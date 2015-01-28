public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // check first row
        boolean firstRow = false;
        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) firstRow = true;
        }
        // check first col
        boolean firstCol = false;
        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) firstCol = true;
        }
        // check
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        // set zero
        for (int c = 1; c < n; c++) {
            if (matrix[0][c] == 0) setCol(matrix, c, m);
        }
        for (int r = 1; r < m; r++) {
            if (matrix[r][0] == 0) setRow(matrix, r, n);
        }
        
        if (firstCol) setCol(matrix, 0, m);
        if (firstRow) setRow(matrix, 0, n);
    }
    
    private void setCol(int[][] matrix, int c, int m) {
        for (int r = 0; r < m; r++) {
            matrix[r][c] = 0;
        }
    }
    
    private void setRow(int[][] matrix, int r, int n) {
        for (int c = 0; c < n; c++) {
            matrix[r][c] = 0;
        }
    }
}
