public class Solution {
    public int singleNumber(int[] A) {
        int x = 0;
        for (int a : A) x ^= a;
        return x;
    }
}
