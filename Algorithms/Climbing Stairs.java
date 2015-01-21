public class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int one = 1, two = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = one + two;
            one = two;
            two = tmp;
        }
        return two;
    }
}
