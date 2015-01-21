public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        boolean bought = false;
        for (int i = 0; i < prices.length; i++) {
            if (!bought) {
                profit -= prices[i];
                bought = true;
            }
            if (bought && (i == prices.length - 1 || prices[i] > prices[i+1])) {
                profit += prices[i];
                bought = false;
            }
        }
        return profit;
    }
}
