public class Solution {
    public void sortColors(int[] A) {
        int n = A.length;
        int red = 0;
        int white = 0;
        for (int i = 0; i < n; i++) {
            int color = A[i];
            A[i] = 2;
            if (color == 1) {
                A[white] = 1;
                white++;
            }
            if (color == 0) {
                A[white] = 1;
                white++;
                A[red] = 0;
                red++;
            }
        }
    }
}
