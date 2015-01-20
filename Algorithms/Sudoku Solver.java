public class Solution {
    boolean[][] hashRows = new boolean[9][9];
    boolean[][] hashCols = new boolean[9][9];
    boolean[][] hashBlks = new boolean[9][9];
    
    public void solveSudoku(char[][] board) {
        // initialize hash
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') validSudoku(r, c, board[r][c]);
            }
        }
        // DFS
        solveNext(board, 0);
    }
    
    public boolean solveNext(char[][] board, int i) {
        if (i == 81) return true;
        int r = i / 9, c = i % 9;
        if (board[r][c] == '.') {
            for (char ch = '1'; ch <= '9'; ch++) {
                if (validSudoku(r, c, ch)) {
                    board[r][c] = ch;
                    if (solveNext(board, i + 1)) return true;
                    else {
                        removeHash(r, c, ch);
                        board[r][c] = '.';
                    }
                }
            }
        } else if (solveNext(board, i + 1)) return true;
        return false;
    }
    
    public int blkIdx(int r, int c) {
        return r / 3 * 3 + c / 3;
    }
    
    public boolean validSudoku(int r, int c, char ch) {
        if (hashRows[r][ch - '1'] || hashCols[c][ch - '1'] || hashBlks[blkIdx(r, c)][ch - '1']) return false;
        else {
            hashRows[r][ch - '1'] = true;
            hashCols[c][ch - '1'] = true;
            hashBlks[blkIdx(r, c)][ch - '1'] = true;
            return true;
        }
    }
    
    public void removeHash(int r, int c, char ch) {
        hashRows[r][ch - '1'] = false;
        hashCols[c][ch - '1'] = false;
        hashBlks[blkIdx(r, c)][ch - '1'] = false;
    }
}
