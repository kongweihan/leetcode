public class Solution {
    public int sqrt(int x) {
        double n = (double)x;
        double right = n;
        double left = 0;
        while (right - left > 1) {
            double mid = (left + right) / 2;
            if (mid * mid == n) return (int)mid;
            if (mid * mid > n) right = mid;
            else left = mid;
        }
        if ((int)right * (int)right > x) return (int)left;
        else return (int)right;
    }
}
