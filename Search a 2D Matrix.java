public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search get row
        int row;
        int left = 0, right = matrix.length - 1;
        if (target == matrix[left][0]) return true;
        if (target == matrix[right][0]) return true;
        if (target > matrix[right][0]) row = right;
        else {
            while (left < right - 1) {
                int mid = (left + right) / 2;
                if (target == matrix[mid][0]) return true;
                else if (target < matrix[mid][0]) right = mid;
                else left = mid;
            }
            row = left;
        }
        // search row `row`
        int N = matrix[0].length;
        if (target == matrix[row][N-1]) return true;
        if (target > matrix[row][N-1]) return false;
        left = 0; right = N - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (target == matrix[row][mid]) return true;
            else if (target < matrix[row][mid]) right = mid;
            else left = mid;
        }
        return false;
    }
}
