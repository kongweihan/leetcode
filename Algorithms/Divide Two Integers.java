public class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg = dividend < 0 ^ divisor < 0;
        long dend = Math.abs((long)dividend);
        long dsor = Math.abs((long)divisor);
        long quot = 0;
        if (dsor == 1) {
            quot = dend;
        } else {
            int i;
            for (i = 0; i < 32; i++) {
                if (dend < dsor) {
                    break;
                }
                dsor = dsor << 1;
            }
            // dend < dsor
            while (dend != 0 && i >= 0) {
                if (dend >= dsor) {
                    quot += 1 << i;
                    dend -= dsor;
                }
                i--;
                dsor = dsor >> 1;
            }
        }
        if (!neg && quot > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return neg ? (int)-quot : (int)quot;
    }
}
