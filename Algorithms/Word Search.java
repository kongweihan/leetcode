public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 1 && board[0].length == 1 && word.length() == 1) return word.charAt(0) == board[0][0];
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, word, 0, r, c, visited)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int idx, int r, int c, boolean[][] visited) {
        if (idx == word.length()) return true;
        if (visited[r][c] == false && word.charAt(idx) == board[r][c]) {
            visited[r][c] = true;
            if (r > 0) {
                if (dfs(board, word, idx+1, r-1, c, visited)) return true;
            }
            if (r < board.length - 1) {
                if (dfs(board, word, idx+1, r+1, c, visited)) return true;
            }
            if (c > 0) {
                if (dfs(board, word, idx+1, r, c-1, visited)) return true;
            }
            if (c < board[0].length - 1) {
                if (dfs(board, word, idx+1, r, c+1, visited)) return true;
            }
            visited[r][c] = false;
        }
        return false;
    }
}
