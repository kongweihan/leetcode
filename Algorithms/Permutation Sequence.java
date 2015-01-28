public class Solution {
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1];
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i-1] * i;
        }
        
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 0; i < n; i++) {
            int d = getDigit(used, k / fact[n - i - 1]);
            k = k % fact[n - i - 1];
            sb.append(d);
        }
        
        return sb.toString();
    }
    
    private int getDigit(boolean[] used, int idx) {
        for (int i = 1; i < used.length; i++) {
            if (used[i] == false) {
                if (idx == 0) {
                    used[i] = true;
                    return i;
                } else {
                    idx--;
                }
            }
        }
        return -1; // never should happen
    }
}
