public class Solution {
    public int maxSubArray(int[] A) {
        // the problem is trivial if the numbers have the same sign
        // sum all numbers if they are all positive
        // choose the max number if they are all negative
        // if two adjacent numbers' sum is positive, they should be
        // seen as one positive number (combined)
        // so the solution is to group the numbers into negative groups
        // with in the max negative group, find the max sum
        int max = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (sum < 0) {
                // "grouping" stops
                sum = A[i];
            } else {
                sum += A[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
