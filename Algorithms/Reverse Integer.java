public class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if (x < 0) neg = true;
        long xx = Math.abs((long)x);
        long y = 0;
        while (xx > 0) {
            y += xx % 10;
            y *= 10;
            xx /= 10;
        }
        y /= 10;
        y = neg ? -y : y;
        if (neg) {
            if (y < Integer.MIN_VALUE) return 0;
            else return (int)y;
        } else {
            if (y > Integer.MAX_VALUE) return 0;
            else return (int)y;
        }
    }
}
