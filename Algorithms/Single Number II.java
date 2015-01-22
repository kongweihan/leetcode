public class Solution {
    public int singleNumber(int[] A) {
        int[] bits = new int[32];
        for (int a : A) {
            for (int i = 0; i < 32; i++) {
                if ((a & 1 << i) != 0) {
                    bits[i] = (bits[i] + 1) % 3;
                }
            }
        }
        int n = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] != 0) {
                n |= 1 << i;
            }
        }
        return n;
    }
}
