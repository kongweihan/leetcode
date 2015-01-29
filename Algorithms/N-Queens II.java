public class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) board[r][c] = '.';
        }
        boolean[] colUsed = new boolean[n];
        dfs(board, colUsed, n, 0);
        return count;
    }
    
    private int count = 0;
    
    private void dfs(char[][] board, boolean[] colUsed, int n, int r) {
        if (r == n) {
            count++;
        } else {
            for (int c = 0; c < n; c++) {
                if (check(board, colUsed, r, c)) {
                    board[r][c] = 'Q';
                    colUsed[c] = true;
                    dfs(board, colUsed, n, r+1);
                    board[r][c] = '.';
                    colUsed[c] = false;
                }
            }
        }
    }
    
    private boolean check(char[][] board, boolean[] colUsed, int r, int c) {
        if (colUsed[c] == true) return false;
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r, j = c; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
