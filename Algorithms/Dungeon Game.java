public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int N = dungeon.length, M = dungeon[0].length;
        int[][] hMin = new int[N][M]; // minimal initial health needed from dungeon[i][j] to arrive dungeon[N-1][M-1]
        // bottom-right
        hMin[N-1][M-1] = dungeon[N-1][M-1] >= 0 ? 1 : 1 - dungeon[N-1][M-1];
        // last row
        for (int j = M-2; j >= 0; j--) {
            hMin[N-1][j] = Math.max(hMin[N-1][j+1] - dungeon[N-1][j], 1);
        }
        // last col
        for (int i = N-2; i >= 0; i--) {
            hMin[i][M-1] = Math.max(hMin[i+1][M-1] - dungeon[i][M-1], 1);
        }
        // rest rows
        for (int i = N-2; i >= 0; i--) {
            for (int j = M-2; j >= 0; j--) {
                hMin[i][j] = Math.max(Math.min(hMin[i+1][j], hMin[i][j+1]) - dungeon[i][j], 1);
            }
        }
        return hMin[0][0];
    }
}
