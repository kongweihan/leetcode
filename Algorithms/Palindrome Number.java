public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int d = 9;
        while (x / (int)(Math.pow(10, d)) == 0 && d > 0) d--;
        for (int i = 0; i < (d+1)/2; i++) {
            if (x / (int)(Math.pow(10, d-i*2)) != x % 10) return false;
            x -= x / (int)(Math.pow(10, d-i*2)) * (int)(Math.pow(10, d-i*2));
            x /= 10;
        }
        return true;
    }
}
