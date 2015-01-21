public class Solution {
    public int candy(int[] ratings) {
        // say adjacent ratings a > b
        // to satisfy the requirement from left and use minimal candies, we have a_left > b_left, b_left = 1
        // to satisfy the requirement from right and use minimal candies, we have a_right = b_right + 1
        // so to satisfy the requirement from both sides and use minimal candies, we take max(a_left, a_right) > max(b_left, b_right)
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }
        
        right[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                right[i] = right[i+1] + 1;
            } else {
                right[i] = 1;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
