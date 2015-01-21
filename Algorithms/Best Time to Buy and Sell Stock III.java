public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) return 0;
        int[] left = new int[n]; // left[i] = max profit from 0 to i
        int[] right = new int[n]; // right[i] max profit from i to n
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
            left[i] = profit;
        }
        
        int max = prices[n-1];
        profit = 0;
        for (int i = n-2; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                profit = Math.max(profit, max - prices[i]);
            }
            right[i] = profit;
        }
        
        profit = 0;
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        
        return profit;
    }
}
