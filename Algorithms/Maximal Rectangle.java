public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int M = matrix[0].length, N = matrix.length;
        int[] hist = new int[M + 2];
        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (matrix[r][c] == '1') hist[c + 1]++;
                else hist[c + 1] = 0;
            }
            max = Math.max(max, maxHistRect(hist));
        }
        return max;
    }
    
    public int maxHistRect(int[] hist) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        stack.push(0);
        for (int i = 1; i < hist.length; i++) {
            if (hist[i] >= hist[stack.peek()]) {
                stack.push(i);
            } else {
                int height = hist[stack.peek()];
                stack.pop();
                max = Math.max(max, height * (i - stack.peek() - 1));
                i--;
            }
        }
        return max;
    }
}
