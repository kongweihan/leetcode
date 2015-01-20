public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check row
        for (int r = 0; r < 9; r++) {
            if (!validRow(board, r)) return false;
        }
        // check column
        for (int c = 0; c < 9; c++) {
            if (!validCol(board, c)) return false;
        }
        // check block
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!validBlk(board, r, c)) return false;
            }
        }
        return true;
    }
    
    public boolean validRow(char[][] board, int r) {
        HashSet<Character> hash = new HashSet<Character>();
        for (int c = 0; c < 9; c++) {
            if (board[r][c] == '.') continue;
            else if (hash.contains(board[r][c])) return false;
            else hash.add(board[r][c]);
        }
        return true;
    }
    
    public boolean validCol(char[][] board, int c) {
        HashSet<Character> hash = new HashSet<Character>();
        for (int r = 0; r < 9; r++) {
            if (board[r][c] == '.') continue;
            else if (hash.contains(board[r][c])) return false;
            else hash.add(board[r][c]);
        }
        return true;
    }
    
    public boolean validBlk(char[][] board, int row, int col) {
        HashSet<Character> hash = new HashSet<Character>();
        for (int r = row * 3; r < (row + 1) * 3; r++) {
            for (int c = col * 3; c < (col + 1) * 3; c++) {
                if (board[r][c] == '.') continue;
                else if (hash.contains(board[r][c])) return false;
                else hash.add(board[r][c]);
            }
        }
        return true;
    }
}
