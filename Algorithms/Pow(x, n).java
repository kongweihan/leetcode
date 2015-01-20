public class Solution {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        long nl = n;
        if (nl < 0) {
            nl = -nl;
            x = 1 / x;
        }
        double sqrt = pow(x, (int)(nl/2));
        return nl % 2 == 0 ? sqrt * sqrt : x * sqrt * sqrt;
    }
}
