public class Solution {
    public int jump(int[] A) {
        int[] min = new int[A.length];
        Arrays.fill(min, -1);
        min[0] = 0;
        int reach = 0;
        for (int i = 0; i < A.length; i++) {
            if (min[i] == -1) return 0;
            for (int j = reach + 1; j <= i + A[i] && j < A.length; j++) {
                min[j] = min[i] + 1;
                reach = j;
                if (j == A.length - 1) break;
            }
        }
        return min[A.length - 1];
    }
}
