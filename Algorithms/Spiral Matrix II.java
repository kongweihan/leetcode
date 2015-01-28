public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mtx = new int[n][n];
        int level = 0;
        int r = 0, c = 0;
        int dir = 0; // 0 right, 1 down, 2 left, 3 up
        for (int i = 1; i <= n*n; i++) {
            mtx[r][c] = i;
            if (dir == 0) {
                if (c == n - level - 1) {
                    dir = 1;
                    r++;
                } else c++;
            } else if (dir == 1) {
                if (r == n - level - 1) {
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
        return mtx;
    }
}
