public class Solution {
    public List<String[]> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) board[r][c] = '.';
        }
        boolean[] colUsed = new boolean[n];
        List<String[]> result = new ArrayList<String[]>();
        dfs(board, colUsed, n, 0, result);
        return result;
    }
    
    private void dfs(char[][] board, boolean[] colUsed, int n, int r, List<String[]> result) {
        if (r == n) {
            addBoard(result, board);
        } else {
            for (int c = 0; c < n; c++) {
                if (check(board, colUsed, r, c)) {
                    board[r][c] = 'Q';
                    colUsed[c] = true;
                    dfs(board, colUsed, n, r+1, result);
                    board[r][c] = '.';
                    colUsed[c] = false;
                }
            }
        }
    }
    
    private void addBoard(List<String[]> result, char[][] board) {
        String[] list = new String[board.length];
        for (int i = 0; i < board.length; i++) {
            list[i] = new String(board[i]);
        }
        result.add(list);
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
