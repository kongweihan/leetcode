public class Solution {
    public int trailingZeroes(int n) {
        long exp = 5;
        int count = 0;
        while (exp <= n) {
            count += n / exp;
            exp *= 5;
        }
        return count;
    }
}
