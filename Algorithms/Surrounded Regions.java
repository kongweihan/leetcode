public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][n-1] == 'O') dfs(i, n-1, board);
        }
        
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') dfs(0, i, board);
            if (board[m-1][i] == 'O') dfs(m-1, i, board);
        }
        
        recoverT(board);
    }
    
    private void dfs(int i, int j, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(i*n+j);
        while (!stack.empty()) {
            int idx = stack.pop();
            i = idx / n;
            j = idx % n;
            board[i][j] = 'T';
            if (i != 0 && board[i-1][j] == 'O') stack.push((i-1)*n+j);
            if (j != 0 && board[i][j-1] == 'O') stack.push(i*n+j-1);
            if (i != board.length - 1 && board[i+1][j] == 'O') stack.push((i+1)*n+j);
            if (j != board[0].length - 1 && board[i][j+1] == 'O') stack.push(i*n+j+1);
        }
    }
    
    private void recoverT(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
}
