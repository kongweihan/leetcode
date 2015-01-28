public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix.length == 0) return list;
        int m = matrix.length, n = matrix[0].length;
        int level = 0;
        int r = 0, c = 0;
        int dir = 0; // 0 right, 1 down, 2 left, 3 up
        for (int i = 1; i <= m*n; i++) {
            list.add(matrix[r][c]);
            if (dir == 0) {
                if (c == n - level - 1) {
                    dir = 1;
                    r++;
                } else c++;
            } else if (dir == 1) {
                if (r == m - level - 1) {
                    dir = 2;
                    c--;
                } else r++;
            } else if (dir == 2) {
                if (c == level) {
                    dir = 3;
                    r--;
                } else c--;
            } else {
                if (r == level + 1) {
                    dir = 0;
                    c++;
                    level++;
                } else r--;
            }
        }
        return list;
    }
}
